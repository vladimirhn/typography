package rest.orders;

import domain.models.orders.OrderSubjectTypesConsumables;
import domain.services.ServiceUser;
import domain.services.abstracts.TypoTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TableController;

@RestController
@RequestMapping("/order_subject_types_consumables")
public class OrderSubjectTypesConsumablesController extends TableController<OrderSubjectTypesConsumables> implements ServiceUser {

    @Override
    protected TypoTableService<OrderSubjectTypesConsumables> getService() {
        return orderSubjectTypesConsumablesService;
    }
}
