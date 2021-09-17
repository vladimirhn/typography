package domain.repositories.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentItem;
import repository.AbstractTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentItemsRepository extends AbstractTableRepository<ComponentItem> {

    public ComponentItemsRepository() {
        super(ComponentItem.class);
    }
}
