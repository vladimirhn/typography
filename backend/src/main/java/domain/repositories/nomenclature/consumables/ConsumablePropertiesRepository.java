package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableProperty;
import repository.TypoTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumablePropertiesRepository extends TypoTableRepository<ConsumableProperty> {

    public ConsumablePropertiesRepository() {
        super(ConsumableProperty.class);
    }
}
