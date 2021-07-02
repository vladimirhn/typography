package rest.consumables;

import domain.models.nomenclature.NomenclatureGroups;
import domain.services.nomenclature.NomenclatureGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class NomenclatureController {

    @Autowired
    NomenclatureGroupsService nomenclatureGroupsService;

    @GetMapping("/nomenclature/get")
    public List<NomenclatureGroups> get() {

        return nomenclatureGroupsService.getWholeNomenclature();
    }

}
