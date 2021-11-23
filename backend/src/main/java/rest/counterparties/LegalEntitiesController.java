package rest.counterparties;

import domain.models.counterparties.LegalEntity;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.Routing;
import rest.abstracts.TypoTableController;
import service.AbstractTableService;

@RestController
@RequestMapping(Routing.UsersPath + "/legal_entities")
public class LegalEntitiesController extends TypoTableController<LegalEntity> implements TypoServiceUser {

    @Override
    protected AbstractTableService<LegalEntity> getService() {
        return legalEntitiesService;
    }
}
