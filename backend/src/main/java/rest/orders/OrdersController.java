package rest.orders;

import domain.models.orders.Order;
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
        orderService.add(data);
    }

    @Override
    @PostMapping("/update")
    public void update(@RequestBody Order data) {
        orderService.update(data);
    }
}
