package rest.purchasing;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.purchasing.PurchasingConsumables;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;
import service.AbstractTableService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/u/purchasing_consumables")
public class PurchasingConsumablesController extends TypoTableController<PurchasingConsumables> implements TypoServiceUser {

    @Override
    protected AbstractTableService<PurchasingConsumables> getService() {
        return purchasingConsumablesService;
    }

    @Override
    @PostMapping("/add")
    public void add(@RequestBody PurchasingConsumables data) {

        System.out.println("Begin");

        getService().insert(data);

        BigDecimal amount = consumableItemsService
                .findFieldValue(data.getConsumableId(), ConsumableItem::getPackageCapacity)
                .ifSomethingMap(capacity -> capacity.multiply(data.getAmount()))
                .ifNothingMap(data::getAmount)
                .get();
    }
}
