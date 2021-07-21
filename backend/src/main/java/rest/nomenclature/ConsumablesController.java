package rest.nomenclature;

import domain.services.defaults.consumables.ConsumablesDefaultsService;
import domain.services.defaults.consumables.ConsumablesTypeDefaultJson;
import domain.services.nomenclature.consumables.ConsumableTypesService;
import domain.services.nomenclature.consumables.ConsumablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.application.JsonLongId;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/consumables")
public class ConsumablesController {

    @Autowired
    ConsumablesService consumablesService;

    @Autowired
    ConsumablesDefaultsService defaultsService;

    @Autowired
    ConsumableTypesService consumableTypesService;

    @GetMapping("/get_all")
    public List<JsonConsumableType> getAll() {
        return consumablesService.createConsumableTypesResponse();
    }

    @GetMapping("/set_defaults")
    public void setDefaults() throws IOException {
        defaultsService.setDefaults();
    }

    @PostMapping("/add")
    public void add(@RequestBody ConsumablesTypeDefaultJson data) {
        consumableTypesService.add(data);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody JsonLongId id) {
        consumableTypesService.cascadeDelete(id);
    }
}
