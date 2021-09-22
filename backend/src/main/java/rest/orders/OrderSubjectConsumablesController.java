package rest.orders;

import domain.models.orders.OrderSubjectConsumables;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;
import service.AbstractTableService;

@RestController
@RequestMapping("/order_subject_consumables")
public class OrderSubjectConsumablesController extends TypoTableController<OrderSubjectConsumables> implements TypoServiceUser {

    @Override
    protected AbstractTableService<OrderSubjectConsumables> getService() {
        return orderSubjectConsumablesService;
    }
}
