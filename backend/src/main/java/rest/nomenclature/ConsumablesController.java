package rest.nomenclature;

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
    public JsonConsumableType getAll(@PathVariable(value = "id") String id) {
        return consumablesService.createConsumableTypesResponse(id);
    }

    @GetMapping("/get_types_with_props")
    public List<JsonConsumableType> getTypesWithProps() {
        return consumablesService.selectTypesWithProps();
    }

    @GetMapping("/set_defaults")
    public void setDefaults() throws IOException {
        defaultsService.setDefaults();
    }

    @PostMapping("/add_type_with_props")
    public void addTypeWithProps(@RequestBody ConsumablesTypeDefaultJson data) {
        consumableTypesService.addTypeWithProps(data);
    }

    @PostMapping("/add_item")
    public List<String> addItem(@RequestBody JsonConsumableType data) {
        return consumableItemsService.add(data);
    }

    @GetMapping("/delete_type/{id}")
    public void delete_type(@PathVariable(value = "id") String id) {
        consumableTypesService.cascadeDelete(id);
    }

    @GetMapping("/delete_item/{id}")
    public void delete_item(@PathVariable(value = "id") String id) {
        consumableItemsService.cascadeDelete(id);
    }
}
