package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import repository.AbstractTableRepository;
import domain.repositories.nomenclature.consumables.ConsumablePropertiesValuesRepository;
import service.AbstractTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("consumablePropertiesValuesService")
public class ConsumablePropertiesValuesService extends AbstractTableService<ConsumablePropertyValue> {

    @Autowired
    ConsumablePropertiesValuesRepository repository;

    @Override
    protected AbstractTableRepository<ConsumablePropertyValue> getRepository() {
        return repository;
    }
}
