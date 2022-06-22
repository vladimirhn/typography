package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableType;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.v2.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.USERS_PATH + "/consumable_types2")
public class ConsumableTypes2Controller extends AbstractStringIdTableController<ConsumableType> implements TypoServiceUser {

}
