package domain.services.orders;

import domain.models.orders.OrderSubjectTypesConsumables;
import repository.AbstractTableRepository;
import domain.repositories.orders.OrderSubjectTypesConsumablesRepository;
import service.AbstractTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Deprecated
@Service("orderSubjectTypesConsumablesService")
public class OrderSubjectTypesConsumablesService extends AbstractTableService<OrderSubjectTypesConsumables> {

    @Autowired
    OrderSubjectTypesConsumablesRepository repository;
    @Override
    protected AbstractTableRepository<OrderSubjectTypesConsumables> getRepository() {
        return repository;
    }

}
