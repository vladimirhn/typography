package rest.application;

import domain.models.nomenclature.NomenclatureItems;
import domain.services.nomenclature.NomenclatureItemsService;
import domain.services.response.KResponse;
import domain.services.response.KResponseComposer;
import domain.services.response.SimpleTableResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestController {

    @Autowired
    NomenclatureItemsService nomenclatureItemsService;

    @Autowired
    KResponseComposer responseComposer;

    @GetMapping("/test")
    public SimpleTableResponse get() {

        return responseComposer.createFrom(nomenclatureItemsService.findAll(), NomenclatureItems.class);
    }
}
