package rest.orders;

import domain.models.orders.OrderConsumable;
import domain.services.abstracts.TypoServiceUser;
import kpersistence.v1.query.KFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;
import service.v1.AbstractTableService;

@RestController
@RequestMapping("/order_consumable")
public class OrderConsumableController extends TypoTableController<OrderConsumable, KFilter> implements TypoServiceUser {

    @Override
    protected AbstractTableService<OrderConsumable> getService() {
        return orderConsumableService;
    }
}
