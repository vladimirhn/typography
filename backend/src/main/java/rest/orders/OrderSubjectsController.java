package rest.orders;

import domain.models.orders.OrderSubject;
import domain.services.abstracts.TypoServiceUser;
import kpersistence.query.KFilter;
import org.springframework.web.bind.annotation.*;
import rest.abstracts.TypoTableController;
import rest.response.tables.TableDataResponse;
import service.AbstractTableService;

@RestController
@RequestMapping("/order_subjects")
public class OrderSubjectsController extends TypoTableController<OrderSubject, KFilter> implements TypoServiceUser {

    @Override
    protected AbstractTableService<OrderSubject> getService() {
        return orderSubjectService;
    }

    @GetMapping("/get_all")
    public TableDataResponse<OrderSubject> getAll() {
        return getAllTranslatedResponse(orderSubjectService.getAll());
    }

    @Override
    @PostMapping("/insert")
    public void insert(@RequestBody OrderSubject data) {
        orderSubjectService.add(data);
    }

    @Override
    @PostMapping("/update")
    public void update(@RequestBody OrderSubject data) {
        orderSubjectService.update(data);
    }

    @Override
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") String id) {
        orderSubjectService.delete(id);
    }
}
