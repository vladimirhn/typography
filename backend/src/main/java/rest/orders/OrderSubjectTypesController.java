package rest.orders;

import domain.models.orders.OrderSubjectType;
import domain.services.ServiceUser;
import domain.services.abstracts.TypoTableService;
import org.springframework.web.bind.annotation.*;
import rest.abstracts.TableController;
import rest.responses.TableDataResponse;

@RestController
@RequestMapping("/order_subject_types")
public class OrderSubjectTypesController extends TableController<OrderSubjectType> implements ServiceUser {

    @Override
    protected TypoTableService<OrderSubjectType> getService() {
        return orderSubjectTypeService;
    }

    @GetMapping("/get_all")
    public TableDataResponse<OrderSubjectType> getAll() {
        return new TableDataResponse<>(orderSubjectTypeService.getAll());
    }

    @Override
    @PostMapping("/add")
    public void add(@RequestBody OrderSubjectType data) {
        orderSubjectTypeService.add(data);
    }

    @Override
    @PostMapping("/update")
    public void update(@RequestBody OrderSubjectType data) {
        orderSubjectTypeService.update(data);
    }

    @Override
    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") String id) {
        orderSubjectTypeService.delete(id);
    }
}
