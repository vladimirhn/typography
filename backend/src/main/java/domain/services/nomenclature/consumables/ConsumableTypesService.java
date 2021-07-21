package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.nomenclature.consumables.ConsumableProperty;
import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import domain.models.nomenclature.consumables.ConsumableType;
import domain.repositories.abstracts.TypoRepository;
import domain.repositories.nomenclature.consumables.ConsumableTypesRepository;
import domain.services.abstracts.TypoService;
import domain.services.application.IdService;
import domain.services.defaults.consumables.ConsumablesTypeDefaultJson;
import kcollections.CollectionFactory;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import rest.application.JsonLongId;

import java.util.stream.Collectors;

@Service("consumableTypesService")
public class ConsumableTypesService extends TypoService<ConsumableType> {

    @Autowired
    ConsumableTypesRepository repository;
    @Override
    protected TypoRepository<ConsumableType> getRepository() {
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

    public void add(ConsumablesTypeDefaultJson data) {

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

    public void cascadeDelete(JsonLongId id) {

        long typeId = id.getId();

        KList<ConsumableItem> items = consumableItemsService.selectByField(ConsumableItem::setTypeId, typeId);
        KList<ConsumableProperty> properties = consumablePropertiesService.selectByField(ConsumableProperty::setTypeId, typeId);
        KList<ConsumablePropertyValue> propValues = CollectionFactory.makeArrayList();
        properties.forEach(prop -> {
            propValues.addAll(consumablePropertiesValuesService.selectByField(ConsumablePropertyValue::setPropertyId, prop.getId()));
        });

        delete(typeId);
        items.mapEachBy(ConsumableItem::getId).useEachBy(consumableItemsService::delete);
        properties.mapEachBy(ConsumableProperty::getId).useEachBy(consumablePropertiesService::delete);
        propValues.mapEachBy(ConsumablePropertyValue::getId).useEachBy(consumablePropertiesValuesService::delete);
    }
}
