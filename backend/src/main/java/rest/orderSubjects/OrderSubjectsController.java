package rest.orderSubjects;

import domain.models.orders.OrderSubject;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.ORDER_SUBJECTS)
public class OrderSubjectsController extends AbstractStringIdTableController<OrderSubject> implements TypoServiceUser {

//    @GetMapping("/get_all")
//    public TableDataResponse<OrderSubject> getAll() {
//        return orderSubjectService.getAll();
//    }

//    @Override
//    @PostMapping("/insert")
//    public void insert(@RequestBody OrderSubject data) {
//        orderSubjectService.add(data);
//    }
//
//    @Override
//    @PostMapping("/update")
//    public void update(@RequestBody OrderSubject data) {
//        orderSubjectService.update(data);
//    }

//    @Override
//    @GetMapping("/delete/{id}")
//    public void delete(@PathVariable(value = "id") String id) {
//        orderSubjectService.delete(id);
//    }
}
