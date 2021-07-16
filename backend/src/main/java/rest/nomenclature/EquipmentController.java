package rest.nomenclature;

import domain.services.defaults.equipment.EquipmentDefaultsService;
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

    @GetMapping("/set_defaults")
    public void setDefaults() throws IOException {
        defaultsService.setDefaults();
    }
}
