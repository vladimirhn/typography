package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableType;
import domain.services.ServiceUser;
import service.TypoTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TableController;

@RestController
@RequestMapping("/consumable_types")
public class ConsumableTypesController extends TableController<ConsumableType> implements ServiceUser {

    @Override
    protected TypoTableService<ConsumableType> getService() {
        return consumableTypesService;
    }
}
