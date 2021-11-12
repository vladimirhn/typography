package domain.services.stock;

import domain.models.stock.OrderConsumedConsumablesBalanceView;
import domain.repositories.stock.OrderConsumedConsumablesBalanceViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AbstractViewRepository;
import service.AbstractViewService;

@Service("orderConsumedConsumablesBalanceViewService")
public class OrderConsumedConsumablesBalanceViewService extends AbstractViewService<OrderConsumedConsumablesBalanceView> {

    @Autowired
    OrderConsumedConsumablesBalanceViewRepository repository;
    @Override
    protected AbstractViewRepository<OrderConsumedConsumablesBalanceView> getRepository() {
        return repository;
    }

}
