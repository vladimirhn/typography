package domain.services.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentItem;
import domain.models.nomenclature.equipment.EquipmentItem;
import domain.models.nomenclature.equipment.EquipmentType;
import repository.TypoTableRepository;
import domain.repositories.nomenclature.equipment.EquipmentTypesRepository;
import domain.services.abstracts.TypoTableService;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("equipmentTypesService")
public class EquipmentTypesService extends TypoTableService<EquipmentType> {

    @Autowired
    EquipmentTypesRepository repository;
    @Override
    protected TypoTableRepository<EquipmentType> getRepository() {
        return repository;
    }

    @Autowired
    EquipmentItemsService equipmentItemsService;
    @Autowired
    ComponentItemsService componentItemsService;

    public KList<EquipmentType> getAllWithChildren() {
        KList<EquipmentType> all = selectAll();
        all.useEachBy(this::setEquipmentItems);
        all.useEachBy(this::setComponentItems);
        return all;
    }

    private void setEquipmentItems(EquipmentType equipmentType) {
        equipmentType.setEquipmentItems(equipmentItemsService.selectByField(EquipmentItem::setTypeId, equipmentType.getId()));
    }

    private void setComponentItems(EquipmentType equipmentType) {
        equipmentType.setComponentItems(componentItemsService.selectByField(ComponentItem::setEquipmentTypeId, equipmentType.getId()));
    }
}
