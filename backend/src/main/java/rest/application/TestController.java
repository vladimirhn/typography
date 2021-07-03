package rest.application;

import domain.models.nomenclature.NomenclatureItem;
import domain.services.nomenclature.NomenclatureItemsService;
import domain.services.response.KResponseComposer;
import domain.services.response.SimpleTableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController()
public class TestController {

    @Autowired
    NomenclatureItemsService nomenclatureItemsService;

    @Autowired
    KResponseComposer responseComposer;

    @GetMapping("/nomenclature/get")
    public SimpleTableResponse get() {

        List<NomenclatureItem> items = nomenclatureItemsService.findAll();
        items.sort(Comparator.comparing(NomenclatureItem::getGroupCode));
        return responseComposer.createFrom(items, NomenclatureItem.class);
    }

    @PostMapping(path = "/nomenclature/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insert(@RequestBody NomenclatureItem item) {
        nomenclatureItemsService.insert(item);
    }
}
