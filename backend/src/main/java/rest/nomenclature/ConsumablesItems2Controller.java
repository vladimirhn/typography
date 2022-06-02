package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.v2.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.USERS_PATH + "/consumables2")
public class ConsumablesItems2Controller extends AbstractStringIdTableController<ConsumableItem> implements TypoServiceUser {
}
