package rest.orders;

import domain.models.orders.Order;
import domain.models.orders.OrderSubject;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.*;
import rest.abstracts.TypoTableController;
import rest.response.TableDataResponse;
import service.AbstractTableService;

@RestController
@RequestMapping("/orders")
public class OrdersController extends TypoTableController<Order> implements TypoServiceUser {

    @Override
    protected AbstractTableService<Order> getService() {
        return orderService;
    }

    @GetMapping("/get_all")
    public TableDataResponse<Order> getAll() {
        return getAllTranslatedResponse(orderService.getAll());
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
