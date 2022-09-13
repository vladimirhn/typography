package rest.purchasing;

import domain.models.purchasing.PurchasingConsumables;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.v2.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping("/u/purchasing_consumables")
public class PurchasingConsumablesController extends AbstractStringIdTableController<PurchasingConsumables> implements TypoServiceUser {

    @PostMapping("/insert")
    public void insert(@RequestBody PurchasingConsumables data) {

        //TODO:defaults
        service().insert(data);
    }
}
