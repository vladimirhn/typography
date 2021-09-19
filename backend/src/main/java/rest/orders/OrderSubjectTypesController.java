package rest.orders;

import domain.models.orders.OrderSubjectType;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.*;
import rest.abstracts.TypoTableController;
import rest.response.TableDataResponse;
import service.AbstractTableService;

@RestController
@RequestMapping("/order_subject_types")
public class OrderSubjectTypesController extends TypoTableController<OrderSubjectType> implements TypoServiceUser {

    @Override
    protected AbstractTableService<OrderSubjectType> getService() {
        return orderSubjectTypeService;
    }

    @GetMapping("/get_all")
    public TableDataResponse<OrderSubjectType> getAll() {
        return new TableDataResponse<>(orderSubjectTypeService.getAll(), typoDictionaryService);
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
