package domain.services.purchasing;

import domain.models.nomenclature.equipment.ComponentItem;
import domain.models.nomenclature.equipment.EquipmentItem;
import domain.models.nomenclature.equipment.EquipmentType;
import domain.models.purchasing.PurchasingConsumables;
import domain.repositories.abstracts.TypoRepository;
import domain.repositories.nomenclature.equipment.EquipmentTypesRepository;
import domain.repositories.purchasing.PurchasingConsumablesRepository;
import domain.services.abstracts.TypoService;
import domain.services.nomenclature.equipment.ComponentItemsService;
import domain.services.nomenclature.equipment.EquipmentItemsService;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("purchasingConsumablesService")
public class PurchasingConsumablesService extends TypoService<PurchasingConsumables> {

    @Autowired
    PurchasingConsumablesRepository repository;
    @Override
    protected TypoRepository<PurchasingConsumables> getRepository() {
        return repository;
    }

}
