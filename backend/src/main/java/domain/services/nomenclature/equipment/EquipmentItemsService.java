package domain.services.nomenclature.equipment;

import domain.models.nomenclature.equipment.EquipmentItem;
import repository.AbstractTableRepository;
import domain.repositories.nomenclature.equipment.EquipmentItemsRepository;
import service.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("equipmentItemsService")
public class EquipmentItemsService extends TypoTableService<EquipmentItem> {

    @Autowired
    EquipmentItemsRepository repository;

    @Override
    protected AbstractTableRepository<EquipmentItem> getRepository() {
        return repository;
    }
}
