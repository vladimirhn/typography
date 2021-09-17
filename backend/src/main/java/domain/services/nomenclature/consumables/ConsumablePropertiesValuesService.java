package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import kpersistence.repository.TypoTableRepository;
import domain.repositories.nomenclature.consumables.ConsumablePropertiesValuesRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("consumablePropertiesValuesService")
public class ConsumablePropertiesValuesService extends TypoTableService<ConsumablePropertyValue> {

    @Autowired
    ConsumablePropertiesValuesRepository repository;

    @Override
    protected TypoTableRepository<ConsumablePropertyValue> getRepository() {
        return repository;
    }
}
