package rest.orders;

import domain.models.orders.Parameter;
import domain.services.abstracts.TypoServiceUser;
import kpersistence.v1.query.KFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;
import service.v1.AbstractTableService;

@RestController
@RequestMapping("/parameters")
public class ParametersController extends TypoTableController<Parameter, KFilter> implements TypoServiceUser {

    @Override
    protected AbstractTableService<Parameter> getService() {
        return parameterService;
    }

}
