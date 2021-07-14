package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import domain.repositories.abstracts.TypoRepository;
import domain.repositories.nomenclature.consumables.ConsumablePropertiesValuesRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("consumablePropertiesValuesService")
public class ConsumablePropertiesValuesService extends TypoService<ConsumablePropertyValue> {

    @Autowired
    ConsumablePropertiesValuesRepository repository;

    @Override
    protected TypoRepository<ConsumablePropertyValue> getRepository() {
        return repository;
    }
}
