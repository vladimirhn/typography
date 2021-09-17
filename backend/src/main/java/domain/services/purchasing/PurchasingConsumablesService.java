package domain.services.purchasing;

import domain.models.purchasing.PurchasingConsumables;
import repository.AbstractTableRepository;
import domain.repositories.purchasing.PurchasingConsumablesRepository;
import service.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("purchasingConsumablesService")
public class PurchasingConsumablesService extends TypoTableService<PurchasingConsumables> {

    @Autowired
    PurchasingConsumablesRepository repository;
    @Override
    protected AbstractTableRepository<PurchasingConsumables> getRepository() {
        return repository;
    }

}
