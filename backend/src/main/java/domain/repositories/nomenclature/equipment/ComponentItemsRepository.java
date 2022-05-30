package domain.repositories.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentItem;
import repository.v1.AbstractTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentItemsRepository extends AbstractTableRepository<ComponentItem> {

    public ComponentItemsRepository() {
        super(ComponentItem.class);
    }
}
