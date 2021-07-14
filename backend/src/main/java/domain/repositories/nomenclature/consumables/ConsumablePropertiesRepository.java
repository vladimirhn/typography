package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableProperty;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumablePropertiesRepository extends TypoRepository<ConsumableProperty> {

    public ConsumablePropertiesRepository() {
        super(ConsumableProperty.class);
    }
}
