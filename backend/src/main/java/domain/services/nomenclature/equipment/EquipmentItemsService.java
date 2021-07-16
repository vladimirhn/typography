package domain.services.nomenclature.equipment;

import domain.models.nomenclature.equipment.EquipmentItem;
import domain.repositories.abstracts.TypoRepository;
import domain.repositories.nomenclature.equipment.EquipmentItemsRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("equipmentItemsService")
public class EquipmentItemsService extends TypoService<EquipmentItem> {

    @Autowired
    EquipmentItemsRepository repository;

    @Override
    protected TypoRepository<EquipmentItem> getRepository() {
        return repository;
    }
}
