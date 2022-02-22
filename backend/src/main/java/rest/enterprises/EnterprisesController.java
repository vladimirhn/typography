package rest.enterprises;

import domain.models.enterprises.Enterprise;
import domain.services.abstracts.TypoServiceUser;
import kpersistence.query.KFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.abstracts.TypoTableController;
import service.AbstractTableService;

@RestController
@RequestMapping(EndPoint.ENTERPRISES)
public class EnterprisesController extends TypoTableController<Enterprise, KFilter> implements TypoServiceUser {

    @Override
    protected AbstractTableService<Enterprise> getService() {
        return enterprisesService;
    }
}
