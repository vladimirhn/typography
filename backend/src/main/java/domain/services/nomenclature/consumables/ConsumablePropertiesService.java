package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableProperty;
import domain.repositories.abstracts.TypoTableRepository;
import domain.repositories.nomenclature.consumables.ConsumablePropertiesRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("consumablePropertiesService")
public class ConsumablePropertiesService extends TypoTableService<ConsumableProperty> {

    @Autowired
    ConsumablePropertiesRepository repository;

    @Override
    protected TypoTableRepository<ConsumableProperty> getRepository() {
        return repository;
    }
}
