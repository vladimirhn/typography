package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.nomenclature.consumables.ConsumableProperty;
import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import domain.models.nomenclature.consumables.ConsumableType;
import domain.services.abstracts.TypoServiceUser;
import kcollections.CollectionFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import rest.EndPoint;
import rest.v2.controllers.AbstractStringIdTableController;

@Transactional
@RestController
@RequestMapping(EndPoint.CONSUMABLE_TYPES)
public class ConsumableTypesController extends AbstractStringIdTableController<ConsumableType> implements TypoServiceUser {

    @Override
    @PostMapping("/insert")
    public void insert(@RequestBody ConsumableType data) {
        String typeId = service().insert(data);
        data.getProperties().forEach((ConsumableProperty property) -> {
            property.setTypeId(typeId);
            consumablePropertiesService.insert(property);
        });
    }

    @Override
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") String id) {
        ConsumableItem example = new ConsumableItem();
        example.setTypeId(id);

        consumableItems2Service.selectFiltered(example)
                .mapEachBy(ConsumableItem::getId)
                .forEach(consumableItems2Service::delete);

        return super.delete(id);
    }

    @Override
    @PostMapping("/update")
    public void update(@RequestBody ConsumableType data) {

        service().update(data);

        String typeId = data.getId();
        data.getProperties().forEach((ConsumableProperty property) -> {

            if (property.getTypeId() == null) {
                property.setTypeId(typeId);
                consumablePropertiesService.insert(property);
            } else if (property.getId().startsWith("-")) {
                String propertyId = property.getId().substring(1);
                consumablePropertiesService.delete(propertyId);
                consumablePropertiesValuesService.deleteByField(ConsumablePropertyValue::setPropertyId, propertyId);
            } else {
                consumablePropertiesService.update(property);
            }
        });
    }
}
