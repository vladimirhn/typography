package rest.orders;

import domain.models.orders.OrderSubject;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.*;
import rest.abstracts.TypoTableController;
import rest.response.TableDataResponse;
import service.AbstractTableService;

@RestController
@RequestMapping("/order_subjects")
public class OrderSubjectsController extends TypoTableController<OrderSubject> implements TypoServiceUser {

    @Override
    protected AbstractTableService<OrderSubject> getService() {
        return orderSubjectService;
    }

    @GetMapping("/get_all")
    public TableDataResponse<OrderSubject> getAll() {
        return getAllTranslatedResponse(orderSubjectService.getAll());
    }

    @Override
    @PostMapping("/add")
    public void add(@RequestBody OrderSubject data) {
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
