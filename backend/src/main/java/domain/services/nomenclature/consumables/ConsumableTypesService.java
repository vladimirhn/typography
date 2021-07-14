package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableType;
import domain.repositories.abstracts.TypoRepository;
import domain.repositories.nomenclature.consumables.ConsumableTypesRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("consumableTypesService")
public class ConsumableTypesService extends TypoService<ConsumableType> {

    @Autowired
    ConsumableTypesRepository repository;

    @Override
    protected TypoRepository<ConsumableType> getRepository() {
        return repository;
    }
}
