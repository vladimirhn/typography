package rest.orders;

import domain.models.orders.Parameter;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;
import service.AbstractTableService;

@RestController
@RequestMapping("/parameters")
public class ParametersController extends TypoTableController<Parameter> implements TypoServiceUser {

    @Override
    protected AbstractTableService<Parameter> getService() {
        return parameterService;
    }

}
