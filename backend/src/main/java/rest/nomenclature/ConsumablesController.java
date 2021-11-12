package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import domain.services.abstracts.TypoServiceUser;
import domain.services.defaults.consumables.ConsumablesTypeDefaultJson;
import org.springframework.web.bind.annotation.*;
import rest.Routing;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(Routing.UsersPath + "/consumables")
public class ConsumablesController implements TypoServiceUser {

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

    @PostMapping("/update_item")
    public void updateItem(@RequestBody JsonConsumableItem data) {

        consumableItemsService.update(new ConsumableItem(data.getItemId(), null, data.getItem(), data.getPackageCapacity()));

        data.getValues().entrySet().forEach(entry -> {
            entry.getValue().entrySet().forEach(subEntry -> {
                consumablePropertiesValuesService.update(new ConsumablePropertyValue(
                        subEntry.getKey(), null, null, subEntry.getValue()
                ));
            });
        });

    }
}
