package rest.counterparties;

import domain.models.counterparties.LegalEntity;
import domain.services.abstracts.TypoServiceUser;
import kpersistence.query.KFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.abstracts.TypoTableController;
import service.AbstractTableService;

@RestController
@RequestMapping(EndPoint.LEGAL_ENTITIES)
public class LegalEntitiesController extends TypoTableController<LegalEntity, KFilter> implements TypoServiceUser {

    @Override
    protected AbstractTableService<LegalEntity> getService() {
        return legalEntitiesService;
    }
}
