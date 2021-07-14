package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableProperty;
import domain.repositories.abstracts.TypoRepository;
import domain.repositories.nomenclature.consumables.ConsumablePropertiesRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("consumablePropertiesService")
public class ConsumablePropertiesService extends TypoService<ConsumableProperty> {

    @Autowired
    ConsumablePropertiesRepository repository;

    @Override
    protected TypoRepository<ConsumableProperty> getRepository() {
        return repository;
    }
}
