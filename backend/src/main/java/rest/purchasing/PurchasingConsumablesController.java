package rest.purchasing;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.purchasing.PurchasingConsumables;
import domain.services.abstracts.TypoServiceUser;
import kcollections.CollectionFactory;
import koptional.KOptional;
import kpersistence.kfilters.SqlOperator;
import kpersistence.query.QueryProperties;
import kpersistence.query.SqlPredicate;
import org.springframework.web.bind.annotation.*;
import rest.abstracts.TypoTableController;
import rest.response.tables.TableDataResponse;
import service.AbstractTableService;

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
    @PostMapping("/add")
    public void add(@RequestBody PurchasingConsumables data) {

        KOptional<BigDecimal> maybeCapacity = consumableItemsService
                .findFieldValue(data.getConsumableId(), ConsumableItem::getPackageCapacity);

        BigDecimal amount = maybeCapacity
                .ifSomethingMap(capacity -> capacity.multiply(data.getAmount()))
                .ifNothingMap(data::getAmount)
                .get();
        data.setAmount(amount);

        BigDecimal capacity = maybeCapacity.orElse(BigDecimal.ONE);
        data.setCapacity(capacity);

        getService().insert(data);
    }
}
