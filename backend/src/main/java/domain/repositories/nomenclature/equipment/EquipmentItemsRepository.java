package domain.repositories.nomenclature.equipment;

import domain.models.nomenclature.equipment.EquipmentItem;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EquipmentItemsRepository extends TypoRepository<EquipmentItem> {

    public EquipmentItemsRepository() {
        super(EquipmentItem.class);
    }
}
