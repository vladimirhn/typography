package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableProperty;
import repository.v1.AbstractTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumablePropertiesRepository extends AbstractTableRepository<ConsumableProperty> {

    public ConsumablePropertiesRepository() {
        super(ConsumableProperty.class);
    }
}
