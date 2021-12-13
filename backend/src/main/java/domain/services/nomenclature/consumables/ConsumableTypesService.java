package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.nomenclature.consumables.ConsumableProperty;
import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import domain.models.nomenclature.consumables.ConsumableType;
import repository.AbstractTableRepository;
import domain.repositories.nomenclature.consumables.ConsumableTypesRepository;
import service.AbstractTableService;
import kpersistence.RandomId;
import domain.services.defaults.consumables.ConsumablesTypeDefaultJson;
import kcollections.CollectionFactory;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("consumableTypesService")
public class ConsumableTypesService extends AbstractTableService<ConsumableType> {

    @Autowired
    ConsumableTypesRepository repository;
    @Override
    protected AbstractTableRepository<ConsumableType> getRepository() {
        return repository;
    }

    @Autowired
    ConsumablePropertiesService consumablePropertiesService;
    @Autowired
    ConsumableItemsService consumableItemsService;
    @Autowired
    ConsumablePropertiesValuesService consumablePropertiesValuesService;

    public void addTypeWithProps(ConsumablesTypeDefaultJson data) {

        if (data.getProperties().isEmpty()) {
            setDefaultProperty(data);
        }

        String typeId = RandomId.next();

        ConsumableType consumableType = new ConsumableType();
        consumableType.setId(typeId);
        consumableType.setType(data.getType());
        consumableType.setProperties(CollectionFactory
                                        .makeListFrom(data::getProperties)
                                        .mapEachBy(ConsumableProperty::new, typeId));

        insert(consumableType);
        consumableType.getProperties().forEach(consumablePropertiesService::insert);
    }

    private void setDefaultProperty(ConsumablesTypeDefaultJson data) {
        data.getProperties().add("уточнение");
    }

    public void cascadeDelete(String id) {

        if (id == null || id.equals("")) id = "0";

        KList<ConsumableItem> items = consumableItemsService.selectByField(ConsumableItem::setTypeId, id);
//        KList<ConsumableProperty> properties = consumablePropertiesService.selectByField(ConsumableProperty::setTypeId, id);
//        KList<ConsumablePropertyValue> propValues = CollectionFactory.makeArrayList();
//        properties.forEach(prop -> {
//            propValues.addAll(consumablePropertiesValuesService.selectByField(ConsumablePropertyValue::setPropertyId, prop.getId()));
//        });

        softDelete(id);
        items.mapEachBy(ConsumableItem::getId).useEachBy(consumableItemsService::softDelete);
//        properties.mapEachBy(ConsumableProperty::getId).useEachBy(consumablePropertiesService::delete);
//        propValues.mapEachBy(ConsumablePropertyValue::getId).useEachBy(consumablePropertiesValuesService::delete);
    }
}
