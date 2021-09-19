package rest.orders;

import domain.models.orders.Order;
import domain.models.orders.OrderSubject;
import domain.services.TypoServiceUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;
import service.AbstractTableService;

@RestController
@RequestMapping("/orders")
public class OrdersController extends TypoTableController<Order> implements TypoServiceUser {

    @Override
    protected AbstractTableService<Order> getService() {
        return orderService;
    }

    @Override
    @PostMapping("/add")
    public void add(@RequestBody Order data) {

        String orderSubjectName = data.getOrderSubjectName();

        orderSubjectService
                .selectByField(OrderSubject::setName, orderSubjectName)
                .getFirst()
                .ifNothing(() -> data.setOrderSubjectsId(orderSubjectService.insert(new OrderSubject(orderSubjectName))))
                .ifSomething(orderSubject -> data.setOrderSubjectsId(orderSubject.getId()));

        data.setStatus("CREATED");

        orderService.insert(data);
    }
}
