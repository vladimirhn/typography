package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableItem;
import repository.v1.AbstractTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumableItemsRepository extends AbstractTableRepository<ConsumableItem> {

    public ConsumableItemsRepository() {
        super(ConsumableItem.class);
    }
}
