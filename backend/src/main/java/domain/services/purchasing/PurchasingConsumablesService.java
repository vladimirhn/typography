package domain.services.purchasing;

import domain.models.purchasing.PurchasingConsumables;
import kpersistence.repository.TypoTableRepository;
import domain.repositories.purchasing.PurchasingConsumablesRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("purchasingConsumablesService")
public class PurchasingConsumablesService extends TypoTableService<PurchasingConsumables> {

    @Autowired
    PurchasingConsumablesRepository repository;
    @Override
    protected TypoTableRepository<PurchasingConsumables> getRepository() {
        return repository;
    }

}
