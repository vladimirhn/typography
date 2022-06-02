package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.repositories.nomenclature.consumables.ConsumableItems2Repository;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.stereotype.Service;
import service.v2.AbstractStringIdTableService;

import java.util.List;

@Service
public class ConsumableItems2Service extends AbstractStringIdTableService<ConsumableItem> implements TypoServiceUser {

    private ConsumableItems2Repository repository = (ConsumableItems2Repository) repository();

    public List<ConsumableItem> getAllMinimum() {
        return repository.getAllMinimum();
    }

    public List<ConsumableItem> getByTypeMinimum(String typeId) {
        return repository.getByTypeMinimum(typeId);
    }
}
