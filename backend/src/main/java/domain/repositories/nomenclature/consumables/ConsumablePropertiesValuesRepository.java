package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumablePropertiesValuesRepository extends TypoRepository<ConsumablePropertyValue> {

    public ConsumablePropertiesValuesRepository() {
        super(ConsumablePropertyValue.class);
    }
}
