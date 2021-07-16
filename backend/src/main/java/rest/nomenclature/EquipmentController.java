package rest.nomenclature;

import domain.models.nomenclature.equipment.EquipmentType;
import domain.services.defaults.equipment.EquipmentDefaultsService;
import domain.services.nomenclature.equipment.EquipmentTypesService;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    EquipmentDefaultsService defaultsService;

    @Autowired
    EquipmentTypesService equipmentTypesService;

    @GetMapping("/set_defaults")
    public void setDefaults() throws IOException {
        defaultsService.setDefaults();
    }

    @GetMapping("/get_all")
    public KList<EquipmentType> getAll() {
        return equipmentTypesService.getAllWithChildren();
    }
}
