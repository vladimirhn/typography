package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.CONSUMABLE_PROPERTIES)
public class ConsumablePropertiesController extends AbstractStringIdTableController<ConsumableProperty> {

}
