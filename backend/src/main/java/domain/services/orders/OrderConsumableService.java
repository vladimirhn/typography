package domain.services.orders;

import domain.models.orders.OrderConsumable;
import domain.repositories.orders.OrderConsumableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.v1.AbstractTableRepository;
import service.v1.AbstractTableService;

@Service("orderConsumableService")
public class OrderConsumableService extends AbstractTableService<OrderConsumable> {

    @Autowired
    OrderConsumableRepository repository;
    @Override
    protected AbstractTableRepository<OrderConsumable> getRepository() {
        return repository;
    }

}
