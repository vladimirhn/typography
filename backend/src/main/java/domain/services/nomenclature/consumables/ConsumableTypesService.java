package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.nomenclature.consumables.ConsumableProperty;
import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import domain.models.nomenclature.consumables.ConsumableType;
import domain.repositories.abstracts.TypoTableRepository;
import domain.repositories.nomenclature.consumables.ConsumableTypesRepository;
import domain.services.abstracts.TypoTableService;
import domain.services.application.IdService;
import domain.services.defaults.consumables.ConsumablesTypeDefaultJson;
import kcollections.CollectionFactory;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("consumableTypesService")
public class ConsumableTypesService extends TypoTableService<ConsumableType> {

    @Autowired
    ConsumableTypesRepository repository;
    @Override
    protected TypoTableRepository<ConsumableType> getRepository() {
        return repository;
    }

    @Autowired
    IdService idService;
    @Autowired
    ConsumablePropertiesService consumablePropertiesService;
    @Autowired
    ConsumableItemsService consumableItemsService;
    @Autowired
    ConsumablePropertiesValuesService consumablePropertiesValuesService;

    public void addTypeWithProps(ConsumablesTypeDefaultJson data) {

        long typeId = idService.next();

        ConsumableType consumableType = new ConsumableType();
        consumableType.setId(typeId);
        consumableType.setType(data.getType());
        consumableType.setProperties(CollectionFactory
                                        .makeListFrom(data::getProperties)
                                        .mapEachBy(ConsumableProperty::new, typeId));

        insert(consumableType);
        consumableType.getProperties().forEach(consumablePropertiesService::insert);
    }

    public void cascadeDelete(Long id) {

        if (id == null) id = 0L;

        KList<ConsumableItem> items = consumableItemsService.selectByField(ConsumableItem::setTypeId, id);
        KList<ConsumableProperty> properties = consumablePropertiesService.selectByField(ConsumableProperty::setTypeId, id);
        KList<ConsumablePropertyValue> propValues = CollectionFactory.makeArrayList();
        properties.forEach(prop -> {
            propValues.addAll(consumablePropertiesValuesService.selectByField(ConsumablePropertyValue::setPropertyId, prop.getId()));
        });

        delete(id);
        items.mapEachBy(ConsumableItem::getId).useEachBy(consumableItemsService::delete);
        properties.mapEachBy(ConsumableProperty::getId).useEachBy(consumablePropertiesService::delete);
        propValues.mapEachBy(ConsumablePropertyValue::getId).useEachBy(consumablePropertiesValuesService::delete);
    }
}
