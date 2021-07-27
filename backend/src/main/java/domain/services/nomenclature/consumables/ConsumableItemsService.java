package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import domain.repositories.abstracts.TypoTableRepository;
import domain.repositories.nomenclature.consumables.ConsumableItemsRepository;
import domain.services.abstracts.TypoTableService;
import domain.services.application.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.nomenclature.JsonConsumableType;

import java.util.Map;

@Service("consumableItemsService")
public class ConsumableItemsService extends TypoTableService<ConsumableItem> {

    @Autowired
    ConsumableItemsRepository repository;

    @Autowired
    IdService idService;

    @Autowired
    ConsumablePropertiesValuesService consumablePropertiesValuesService;

    @Override
    protected TypoTableRepository<ConsumableItem> getRepository() {
        return repository;
    }

    public void add(JsonConsumableType data) {
        Long typeId = data.getId();

        data.getData().forEach(entry -> {

            Long newItemId = idService.next();

            insert(new ConsumableItem(newItemId, typeId, entry.getItem()));

            entry.getValues().forEach((propId, newValueMap) -> {
                String newValue = newValueMap.values().iterator().next();

                consumablePropertiesValuesService.insert(
                        new ConsumablePropertyValue(idService.next(), newItemId, propId, newValue));
            });
        });
    }

    public void cascadeDelete(Long id) {
        consumablePropertiesValuesService.deleteByField(ConsumablePropertyValue::setItemId, id);
        delete(id);
    }
}
