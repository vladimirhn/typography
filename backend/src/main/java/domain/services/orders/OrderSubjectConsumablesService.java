package domain.services.orders;

import domain.models.orders.OrderSubjectConsumables;
import domain.repositories.orders.OrderSubjectConsumablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.v1.AbstractTableRepository;
import service.v1.AbstractTableService;

@Service("orderSubjectConsumablesService")
public class OrderSubjectConsumablesService extends AbstractTableService<OrderSubjectConsumables> {

    @Autowired
    OrderSubjectConsumablesRepository repository;
    @Override
    protected AbstractTableRepository<OrderSubjectConsumables> getRepository() {
        return repository;
    }

}
