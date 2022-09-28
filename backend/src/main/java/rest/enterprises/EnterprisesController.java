package rest.enterprises;

import domain.models.enterprises.Enterprise;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.v2.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.ENTERPRISES)
public class EnterprisesController extends AbstractStringIdTableController<Enterprise> implements TypoServiceUser {

}
