package rest.orders;

import domain.models.orders.OrderSubject;
import domain.services.ServiceUser;
import service.TypoTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TableController;

@RestController
@RequestMapping("/order_subjects")
public class OrderSubjectsController extends TableController<OrderSubject> implements ServiceUser {

    @Override
    protected TypoTableService<OrderSubject> getService() {
        return orderSubjectService;
    }
}
