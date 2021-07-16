package domain.repositories.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentItem;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentItemsRepository extends TypoRepository<ComponentItem> {

    public ComponentItemsRepository() {
        super(ComponentItem.class);
    }
}
