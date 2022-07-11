package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.v2.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.CONSUMABLE_TYPES)
public class ConsumableTypesController extends AbstractStringIdTableController<ConsumableType> {

}
