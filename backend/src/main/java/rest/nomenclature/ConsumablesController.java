package rest.nomenclature;

import domain.services.nomenclature.consumables.ConsumablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/consumables")
public class ConsumablesController {

    @Autowired
    ConsumablesService consumablesService;

    @GetMapping("/get_all")
    public Map<Long, JsonConsumableType> getAll() {
        return consumablesService.createConsumableTypesResponse();
    }
}
