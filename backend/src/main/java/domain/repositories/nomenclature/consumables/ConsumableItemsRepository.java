package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumableItemsRepository extends TypoRepository<ConsumableItem> {

    public ConsumableItemsRepository() {
        super(ConsumableItem.class);
    }
}
