package rest.orders;

import domain.models.orders.OrderConsumable;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.USERS_PATH + "/order_consumable")
public class OrderConsumableController extends AbstractStringIdTableController<OrderConsumable> implements TypoServiceUser {

}
