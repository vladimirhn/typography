package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.stereotype.Service;
import service.AbstractStringIdTableService;

@Service
public class ConsumableItems2Service extends AbstractStringIdTableService<ConsumableItem> implements TypoServiceUser {
}
