package domain.services.stock;

import domain.models.stock.PurchasedConsumablesBalanceView;
import domain.repositories.stock.PurchasedConsumablesBalanceViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AbstractViewRepository;
import service.AbstractViewService;

@Service("purchasedConsumablesBalanceViewService")
public class PurchasedConsumablesBalanceViewService extends AbstractViewService<PurchasedConsumablesBalanceView> {

    @Autowired
    PurchasedConsumablesBalanceViewRepository repository;
    @Override
    protected AbstractViewRepository<PurchasedConsumablesBalanceView> getRepository() {
        return repository;
    }

}
