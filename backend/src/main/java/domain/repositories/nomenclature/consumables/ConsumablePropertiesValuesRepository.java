package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import repository.v1.AbstractTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumablePropertiesValuesRepository extends AbstractTableRepository<ConsumablePropertyValue> {

    public ConsumablePropertiesValuesRepository() {
        super(ConsumablePropertyValue.class);
    }
}
