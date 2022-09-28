package rest.orders;

import domain.models.orders.Parameter;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.v2.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping("/parameters")
public class ParametersController extends AbstractStringIdTableController<Parameter> implements TypoServiceUser {
}
