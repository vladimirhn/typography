package rest.counterparties;

import domain.models.counterparties.LegalEntity;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.v2.controllers.AbstractStringIdTableController;

@RestController
@RequestMapping(EndPoint.LEGAL_ENTITIES)
public class LegalEntitiesController extends AbstractStringIdTableController<LegalEntity> implements TypoServiceUser {

}
