package rest.orders;

import domain.models.orders.OrderSubjectType;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;
import service.AbstractTableService;

@RestController
@RequestMapping("/order_subject_types")
public class OrderSubjectTypesController extends TypoTableController<OrderSubjectType> implements TypoServiceUser {

    @Override
    protected AbstractTableService<OrderSubjectType> getService() {
        return orderSubjectTypeService;
    }

}
