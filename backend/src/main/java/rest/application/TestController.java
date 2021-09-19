package rest.application;

import domain.models.nomenclature.consumables.ConsumableItem;
import rest.response.KResponseComposer;
import rest.response.SimpleTableResponse;
import domain.services.nomenclature.consumables.ConsumableItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController()
public class TestController {

    @Autowired
    ConsumableItemsService consumableItemsService;

    @Autowired
    KResponseComposer responseComposer;
    @GetMapping("/test")
    public SimpleTableResponse get() {

        System.out.println("Hello from System.out");

        if (true) throw new NullPointerException();

        List<ConsumableItem> items = consumableItemsService.selectAll();
        items.sort(Comparator.comparing(ConsumableItem::getItem));
        return responseComposer.createFrom(items, ConsumableItem.class);
    }
//
//    @PostMapping(path = "/nomenclature/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void insert(@RequestBody NomenclatureItem item) {
//        nomenclatureItemsService.insert(item);
//    }
}
