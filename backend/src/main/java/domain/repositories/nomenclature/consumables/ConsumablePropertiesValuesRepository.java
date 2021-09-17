package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablePropertyValue;
import kpersistence.repository.TypoTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumablePropertiesValuesRepository extends TypoTableRepository<ConsumablePropertyValue> {

    public ConsumablePropertiesValuesRepository() {
        super(ConsumablePropertyValue.class);
    }
}
