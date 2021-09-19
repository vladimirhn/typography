package rest.orders;

import domain.models.orders.OrderSubject;
import domain.services.TypoServiceUser;
import service.AbstractTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;

@RestController
@RequestMapping("/order_subjects")
public class OrderSubjectsController extends TypoTableController<OrderSubject> implements TypoServiceUser {

    @Override
    protected AbstractTableService<OrderSubject> getService() {
        return orderSubjectService;
    }
}
