package rest.orders;

import domain.models.orders.Order;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.USERS_PATH + "/orders2")
public class OrdersController extends AbstractStringIdTableController<Order> implements TypoServiceUser {

}
