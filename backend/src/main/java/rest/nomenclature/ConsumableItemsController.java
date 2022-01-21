package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.services.abstracts.TypoServiceUser;
import kpersistence.query.KFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;
import service.AbstractTableService;

@RestController
@RequestMapping("/u/consumable_items")
public class ConsumableItemsController extends TypoTableController<ConsumableItem, KFilter> implements TypoServiceUser {

    @Override
    protected AbstractTableService<ConsumableItem> getService() {
        return consumableItemsService;
    }
}
