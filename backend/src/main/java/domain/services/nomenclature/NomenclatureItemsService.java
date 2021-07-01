package domain.services.nomenclature;

import domain.models.nomenclature.NomenclatureItems;
import domain.repositories.nomenclature.NomenclatureItemsRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("nomenclatureItemsService")
public class NomenclatureItemsService extends TypoService<NomenclatureItems> {

    @Autowired
    NomenclatureItemsRepository repository;

    public List<NomenclatureItems> findByParentCode(String parentCode) {
        return repository.findByGroupCode(parentCode);
    }
}
