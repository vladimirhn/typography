package domain.repositories.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentItem;
import domain.repositories.abstracts.TypoTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentItemsRepository extends TypoTableRepository<ComponentItem> {

    public ComponentItemsRepository() {
        super(ComponentItem.class);
    }
}
