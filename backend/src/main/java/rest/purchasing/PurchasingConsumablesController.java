package rest.purchasing;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.purchasing.PurchasingConsumables;
import domain.services.abstracts.TypoServiceUser;
import koptional.KOptional;
import org.springframework.web.bind.annotation.*;
import rest.abstracts.TypoTableController;
import rest.v2.response.tables.TableDataResponse;
import service.v1.AbstractTableService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/u/purchasing_consumables")
public class PurchasingConsumablesController extends TypoTableController<PurchasingConsumables, PurchasingConsumables.Filter> implements TypoServiceUser {

    @Override
    protected AbstractTableService<PurchasingConsumables> getService() {
        return purchasingConsumablesService;
    }

    @Override
    @GetMapping("/get_all")
    public TableDataResponse<PurchasingConsumables> getAll() {
//        QueryProperties<PurchasingConsumables> test = QueryProperties.createDefault(PurchasingConsumables.class);
//        SqlPredicate filter = new SqlPredicate("CONSUMABLE_ID", SqlOperator.EQUALS, "fmdqVKI8OQhV");
//        test.setFilters(CollectionFactory.makeList(filter));
        TableDataResponse<PurchasingConsumables> result = getAllTranslatedResponse(getService().select());
        return result;
    }

    @Override
    @PostMapping("/insert")
    public void insert(@RequestBody PurchasingConsumables data) {

        KOptional<BigDecimal> maybeCapacity = consumableItemsService
                .findFieldValue(data.getConsumableId(), ConsumableItem::getPackageCapacity);

//        BigDecimal amount = maybeCapacity
//                .ifSomethingMap(capacity -> capacity.multiply(data.getAmount()))
//                .ifNothingMap(data::getAmount)
//                .get();
//        data.setAmount(amount);

        BigDecimal capacity = maybeCapacity.orElse(BigDecimal.ONE);
        data.setCapacity(capacity);

        getService().insert(data);
    }
}
