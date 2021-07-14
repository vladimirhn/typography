package rest.nomenclature;

import domain.models.nomenclature.consumables.ConsumablesViewLine;
import domain.services.nomenclature.consumables.ConsumablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consumables")
public class ConsumablesController {

    @Autowired
    ConsumablesService consumablesService;

    @GetMapping("/test")
    public Map<Long, JsonConsumableType> test() {
        return consumablesService.createConsumableTypesResponse();
    }
}
