package rest.enterprises;

import domain.models.enterprises.MoneyMovement;
import domain.services.abstracts.TypoServiceUser;
import kpersistence.v1.query.KFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.abstracts.TypoTableController;
import service.v1.AbstractTableService;

@RestController
@RequestMapping(EndPoint.MONEY_MOVEMENTS)
public class MoneyMovementsController extends TypoTableController<MoneyMovement, KFilter> implements TypoServiceUser {

    @Override
    protected AbstractTableService<MoneyMovement> getService() {
        return moneyMovenetsService;
    }
}
