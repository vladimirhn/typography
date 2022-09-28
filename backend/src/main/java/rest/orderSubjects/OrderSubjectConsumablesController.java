package rest.orderSubjects;

import domain.models.orders.OrderSubjectConsumables;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.v2.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping("/order_subject_consumables")
public class OrderSubjectConsumablesController extends AbstractStringIdTableController<OrderSubjectConsumables> implements TypoServiceUser {

}
