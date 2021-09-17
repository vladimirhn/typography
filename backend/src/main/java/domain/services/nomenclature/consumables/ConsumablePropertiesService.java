package domain.services.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableProperty;
import repository.AbstractTableRepository;
import domain.repositories.nomenclature.consumables.ConsumablePropertiesRepository;
import service.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("consumablePropertiesService")
public class ConsumablePropertiesService extends TypoTableService<ConsumableProperty> {

    @Autowired
    ConsumablePropertiesRepository repository;

    @Override
    protected AbstractTableRepository<ConsumableProperty> getRepository() {
        return repository;
    }
}
