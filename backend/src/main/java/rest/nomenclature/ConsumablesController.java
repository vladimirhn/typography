package rest.nomenclature;

import domain.services.defaults.ConsumablesDefaultsService;
import domain.services.nomenclature.consumables.ConsumablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/consumables")
public class ConsumablesController {

    @Autowired
    ConsumablesService consumablesService;

    @Autowired
    ConsumablesDefaultsService defaultsService;

    @GetMapping("/get_all")
    public List<JsonConsumableType> getAll() {
        return consumablesService.createConsumableTypesResponse();
    }

    @GetMapping("/set_defaults")
    public void setDefaults() throws IOException {
        defaultsService.setDefaults();
    }
}
