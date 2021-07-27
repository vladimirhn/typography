package domain.repositories.nomenclature.equipment;

import domain.models.nomenclature.equipment.EquipmentItem;
import domain.repositories.abstracts.TypoTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EquipmentItemsRepository extends TypoTableRepository<EquipmentItem> {

    public EquipmentItemsRepository() {
        super(EquipmentItem.class);
    }
}