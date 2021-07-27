package domain.services.nomenclature.equipment;

import domain.models.nomenclature.equipment.EquipmentItem;
import domain.repositories.abstracts.TypoTableRepository;
import domain.repositories.nomenclature.equipment.EquipmentItemsRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("equipmentItemsService")
public class EquipmentItemsService extends TypoTableService<EquipmentItem> {

    @Autowired
    EquipmentItemsRepository repository;

    @Override
    protected TypoTableRepository<EquipmentItem> getRepository() {
        return repository;
    }
}