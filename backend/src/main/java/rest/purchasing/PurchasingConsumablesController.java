package rest.purchasing;

import domain.models.nomenclature.equipment.EquipmentType;
import domain.models.purchasing.PurchasingConsumables;
import domain.services.defaults.equipment.EquipmentDefaultsService;
import domain.services.nomenclature.equipment.EquipmentTypesService;
import domain.services.purchasing.PurchasingConsumablesService;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/purchasing_consumables")
public class PurchasingConsumablesController {

    @Autowired
    PurchasingConsumablesService purchasingConsumablesService;


    @GetMapping("/get_all")
    public KList<PurchasingConsumables> getAll() {
        return purchasingConsumablesService.selectAll();
    }
}
