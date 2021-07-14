package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablesViewLine;
import domain.repositories.abstracts.TypoViewRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AllConsumablesViewRepository extends TypoViewRepository<ConsumablesViewLine> {

    public AllConsumablesViewRepository() {
        super(ConsumablesViewLine.class);
    }
}
