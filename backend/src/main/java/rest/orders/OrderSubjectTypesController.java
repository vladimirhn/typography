package rest.orders;

import domain.models.orders.OrderSubjectType;
import domain.services.abstracts.TypoServiceUser;
import kpersistence.v1.query.KFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;
import service.v1.AbstractTableService;

@RestController
@RequestMapping("/order_subject_types")
public class OrderSubjectTypesController extends TypoTableController<OrderSubjectType, KFilter> implements TypoServiceUser {

    @Override
    protected AbstractTableService<OrderSubjectType> getService() {
        return orderSubjectTypeService;
    }

}
