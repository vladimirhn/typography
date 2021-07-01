package domain.services.nomenclature;

import domain.models.nomenclature.NomenclatureItems;
import domain.models.nomenclature.NomenclatureGroups;
import domain.repositories.nomenclature.NomenclatureGroupsRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("nomenclatureGroupsService")
public class NomenclatureGroupsService extends TypoService<NomenclatureGroups> {

    @Autowired
    NomenclatureGroupsRepository repository;
    
    @Autowired
    NomenclatureItemsService nomenclatureItemsService;
    
    public List<NomenclatureGroups> getMenusWithSubmenus() {
        List<NomenclatureGroups> nomenclatureGroups = repository.findAll();

        nomenclatureGroups.forEach(group -> {
            List<NomenclatureItems> items = nomenclatureItemsService.findByParentCode(group.getCode());
            group.setItems(items);
        });

        return nomenclatureGroups;
    }
}
