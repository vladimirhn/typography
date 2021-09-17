package domain.services.orders;

import domain.models.orders.OrderSubjectTypesConsumables;
import repository.AbstractTableRepository;
import domain.repositories.orders.OrderSubjectTypesConsumablesRepository;
import service.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderSubjectTypesConsumablesService")
public class OrderSubjectTypesConsumablesService extends TypoTableService<OrderSubjectTypesConsumables> {

    @Autowired
    OrderSubjectTypesConsumablesRepository repository;
    @Override
    protected AbstractTableRepository<OrderSubjectTypesConsumables> getRepository() {
        return repository;
    }

}
