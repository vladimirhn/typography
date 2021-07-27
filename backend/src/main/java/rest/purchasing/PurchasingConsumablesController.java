package rest.purchasing;

import domain.models.purchasing.PurchasingConsumables;
import domain.services.ServiceUser;
import domain.services.abstracts.TypoTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TableController;

@RestController
@RequestMapping("/purchasing_consumables")
public class PurchasingConsumablesController extends TableController<PurchasingConsumables> implements ServiceUser {

    @Override
    protected TypoTableService<PurchasingConsumables> getService() {
        return purchasingConsumablesService;
    }
}
