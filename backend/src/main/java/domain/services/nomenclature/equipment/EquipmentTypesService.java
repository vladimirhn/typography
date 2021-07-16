package domain.services.nomenclature.equipment;

import domain.models.nomenclature.equipment.EquipmentType;
import domain.repositories.abstracts.TypoRepository;
import domain.repositories.nomenclature.equipment.EquipmentTypesRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("equipmentTypesService")
public class EquipmentTypesService extends TypoService<EquipmentType> {

    @Autowired
    EquipmentTypesRepository repository;

    @Override
    protected TypoRepository<EquipmentType> getRepository() {
        return repository;
    }
}
