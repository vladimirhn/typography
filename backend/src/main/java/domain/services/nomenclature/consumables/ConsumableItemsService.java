package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import domain.models.purchasing.PurchasingConsumables;
import kpersistence.RandomId;
import repository.AbstractTableRepository;
import domain.repositories.nomenclature.consumables.ConsumableItemsRepository;
import domain.services.ServiceUser;
import service.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.nomenclature.JsonConsumableType;

import java.util.LinkedList;
import java.util.List;

@Service("consumableItemsService")
public class ConsumableItemsService extends TypoTableService<ConsumableItem> implements ServiceUser {

    @Autowired
    ConsumableItemsRepository repository;

    @Override
    protected AbstractTableRepository<ConsumableItem> getRepository() {
        return repository;
    }

    public List<String> add(JsonConsumableType data) {

        List<String> addedItemsIds = new LinkedList<>();

        String typeId = data.getId();

        data.getData().forEach(entry -> {

            String newItemId = RandomId.next();
            insert(new ConsumableItem(newItemId, typeId, entry.getItem(), entry.getPackageCapacity()));
            addedItemsIds.add(newItemId);

            entry.getValues().forEach((propId, newValueMap) -> {
                String newValue = newValueMap.values().iterator().next();

                consumablePropertiesValuesService.insert(
                        new ConsumablePropertyValue(RandomId.next(), newItemId, propId, newValue));
            });
        });

        return addedItemsIds;
    }

    public void cascadeDelete(String id) {
        consumablePropertiesValuesService.deleteByField(ConsumablePropertyValue::setItemId, id);
        purchasingConsumablesService.deleteByField(PurchasingConsumables::setConsumableId, id);
        delete(id);
    }
}
