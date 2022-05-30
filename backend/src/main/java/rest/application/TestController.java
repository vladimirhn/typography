package rest.application;

import domain.services.nomenclature.consumables.ConsumableItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
public class TestController {

    @Autowired
    ConsumableItemsService consumableItemsService;

    @GetMapping("/test")
    public String get() {

        return null;
    }
//
//    @PostMapping(path = "/nomenclature/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void insert(@RequestBody NomenclatureItem item) {
//        nomenclatureItemsService.insert(item);
//    }
}
