package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.v2.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.CONSUMABLE_ITEMS)
public class ConsumableItemsController extends AbstractStringIdTableController<ConsumableItem> implements TypoServiceUser {

    @Override
    @PostMapping("/insert")
    public void insert(@RequestBody ConsumableItem data) {
        String itemId = service().insert(data);
        data.getPropertyValues()
                .setValue(ConsumablePropertyValue::setItemId, itemId)
                .forEach(consumablePropertiesValuesService::insert);
    }
}
