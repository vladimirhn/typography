package rest.enterprises;

import domain.models.enterprises.MoneyMovement;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.MONEY_MOVEMENTS)
public class MoneyMovementsController extends AbstractStringIdTableController<MoneyMovement> implements TypoServiceUser {

}
