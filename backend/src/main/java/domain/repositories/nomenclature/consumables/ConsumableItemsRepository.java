package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableItem;
import kpersistence.repository.TypoTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumableItemsRepository extends TypoTableRepository<ConsumableItem> {

    public ConsumableItemsRepository() {
        super(ConsumableItem.class);
    }
}
