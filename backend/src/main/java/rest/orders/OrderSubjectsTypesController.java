package rest.orders;

import domain.models.orders.OrderSubjectType;
import domain.services.ServiceUser;
import domain.services.abstracts.TypoTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TableController;

@RestController
@RequestMapping("/order_subject_types")
public class OrderSubjectsTypesController extends TableController<OrderSubjectType> implements ServiceUser {

    @Override
    protected TypoTableService<OrderSubjectType> getService() {
        return orderSubjectTypeService;
    }
}
