package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.v2.controllers.AbstractStringIdTableController;

import java.util.List;

@RestController
@RequestMapping(EndPoint.USERS_PATH + "/consumables2")
public class ConsumablesItems2Controller extends AbstractStringIdTableController<ConsumableItem> implements TypoServiceUser {

    @GetMapping("/get_all_minimum")
    public List<ConsumableItem> getAllMinimum() {
        return consumableItems2Service.getAllMinimum();
    }
    @GetMapping("/get_by_type_minimum/{typeId}")
    public List<ConsumableItem> getByTypeMinimum(@PathVariable String typeId) {
        return consumableItems2Service.getByTypeMinimum(typeId);
    }
}
