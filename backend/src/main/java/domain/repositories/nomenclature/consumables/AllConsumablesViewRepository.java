package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablesView;
import kpersistence.repository.TypoViewRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AllConsumablesViewRepository extends TypoViewRepository<ConsumablesView> {

    public AllConsumablesViewRepository() {
        super(ConsumablesView.class);
    }
}
