package rest.orders;

import domain.models.orders.Order2;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.v2.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.USERS_PATH + "/orders2")
public class Orders2Controller extends AbstractStringIdTableController<Order2> implements TypoServiceUser {

}
