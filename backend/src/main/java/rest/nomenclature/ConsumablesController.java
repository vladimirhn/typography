package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableType;
import domain.services.defaults.consumables.ConsumablesDefaultsService;
import domain.services.defaults.consumables.ConsumablesTypeDefaultJson;
import domain.services.nomenclature.consumables.ConsumableItemsService;
import domain.services.nomenclature.consumables.ConsumableTypesService;
import domain.services.nomenclature.consumables.ConsumablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    ConsumableItemsService consumableItemsService;

    @GetMapping("/get_all")
    public List<JsonConsumableType> getAll() {
        return consumablesService.createConsumableTypesResponse();
    }
    @GetMapping("/get_type_cascade/{id}")
    public JsonConsumableType getAll(@PathVariable(value = "id") Long id) {
        return consumablesService.createConsumableTypesResponse(id);
    }

    @GetMapping("/get_types")
    public List<ConsumableType> getAllTypes() {
        return consumableTypesService.selectAll().sortAsc(ConsumableType::getType);
    }

    @GetMapping("/set_defaults")
    public void setDefaults() throws IOException {
        defaultsService.setDefaults();
    }

    @PostMapping("/add_type")
    public void addType(@RequestBody ConsumablesTypeDefaultJson data) {
        consumableTypesService.add(data);
    }

    @PostMapping("/add_item")
    public void addItem(@RequestBody JsonConsumableType data) {
        consumableItemsService.add(data);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        consumableTypesService.cascadeDelete(id);
    }
}
