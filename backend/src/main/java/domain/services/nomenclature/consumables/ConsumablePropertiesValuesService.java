package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import repository.v1.AbstractTableRepository;
import domain.repositories.nomenclature.consumables.ConsumablePropertiesValuesRepository;
import service.v1.AbstractTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class ConsumablePropertiesValuesService extends AbstractTableService<ConsumablePropertyValue> {

    @Autowired
    ConsumablePropertiesValuesRepository repository;

    @Override
    protected AbstractTableRepository<ConsumablePropertyValue> getRepository() {
        return repository;
    }
}
