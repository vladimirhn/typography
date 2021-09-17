package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumablesView;
import repository.AbstractViewRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AllConsumablesViewRepository extends AbstractViewRepository<ConsumablesView> {

    public AllConsumablesViewRepository() {
        super(ConsumablesView.class);
    }
}
