package rest.orderSubjects;

import domain.models.orders.OrderSubjectType;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.ORDER_SUBJECTS_TYPES)
public class OrderSubjectTypesController extends AbstractStringIdTableController<OrderSubjectType> implements TypoServiceUser {

}
