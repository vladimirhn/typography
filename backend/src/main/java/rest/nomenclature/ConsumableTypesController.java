package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableProperty;
import domain.models.nomenclature.consumables.ConsumableType;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.v2.controllers.AbstractStringIdTableController;

@Transactional
@RestController
@RequestMapping(EndPoint.CONSUMABLE_TYPES)
public class ConsumableTypesController extends AbstractStringIdTableController<ConsumableType> implements TypoServiceUser {

    @Override
    @PostMapping("/insert")
    public void insert(@RequestBody ConsumableType data) {
        String typeId = service().insert(data);
        data.getProperties().forEach((ConsumableProperty property) -> {
            property.setTypeId(typeId);
        });
    }
}
