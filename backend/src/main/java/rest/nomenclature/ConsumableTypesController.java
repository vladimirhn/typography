package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableType;
import domain.services.abstracts.TypoServiceUser;
import service.AbstractTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;

@RestController
@RequestMapping("/consumable_types")
public class ConsumableTypesController extends TypoTableController<ConsumableType> implements TypoServiceUser {

    @Override
    protected AbstractTableService<ConsumableType> getService() {
        return consumableTypesService;
    }
}
