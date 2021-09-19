package rest.orders;

import domain.models.orders.OrderSubjectTypesConsumables;
import domain.services.TypoServiceUser;
import service.AbstractTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;

@RestController
@RequestMapping("/order_subject_types_consumables")
public class OrderSubjectTypesConsumablesController extends TypoTableController<OrderSubjectTypesConsumables> implements TypoServiceUser {

    @Override
    protected AbstractTableService<OrderSubjectTypesConsumables> getService() {
        return orderSubjectTypesConsumablesService;
    }
}
