package rest.orders;

import domain.models.orders.Order;
import domain.services.abstracts.TypoServiceUser;
import kcollections.KList;
import kpersistence.query.KFilter;
import org.springframework.web.bind.annotation.*;
import rest.EndPoint;
import rest.abstracts.TypoTableController;
import rest.response.tables.TableDataResponse;
import service.AbstractTableService;

@RestController
@RequestMapping(EndPoint.USERS_PATH + "/orders")
public class OrdersController extends TypoTableController<Order, KFilter> implements TypoServiceUser {

    @Override
    protected AbstractTableService<Order> getService() {
        return orderService;
    }

    @GetMapping("/get_all")
    public TableDataResponse<Order> getAll() {
        KList<Order> result = orderService.getAll();
        return getAllTranslatedResponse(result);
    }

    @Override
    @PostMapping("/insert")
    public void insert(@RequestBody Order data) {
        orderService.add(data);
    }

    @Override
    @PostMapping("/update")
    public void update(@RequestBody Order data) {
        orderService.update(data);
    }

    @Override
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") String id) {
        orderService.delete(id);
    }
}
