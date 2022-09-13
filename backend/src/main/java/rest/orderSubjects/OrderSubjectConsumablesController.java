package rest.orderSubjects;

import domain.models.orders.OrderSubjectConsumables;
import domain.services.abstracts.TypoServiceUser;
import kpersistence.v1.query.KFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;
import service.v1.AbstractTableService;

@RestController
@RequestMapping("/order_subject_consumables")
public class OrderSubjectConsumablesController extends TypoTableController<OrderSubjectConsumables, KFilter> implements TypoServiceUser {

    @Override
    protected AbstractTableService<OrderSubjectConsumables> getService() {
        return orderSubjectConsumablesService;
    }
}
