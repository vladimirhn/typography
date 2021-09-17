package domain.repositories.nomenclature.equipment;

import domain.models.nomenclature.equipment.EquipmentItem;
import repository.AbstractTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EquipmentItemsRepository extends AbstractTableRepository<EquipmentItem> {

    public EquipmentItemsRepository() {
        super(EquipmentItem.class);
    }
}
