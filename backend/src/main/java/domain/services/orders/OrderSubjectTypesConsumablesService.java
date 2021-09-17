package domain.services.orders;

import domain.models.orders.OrderSubjectTypesConsumables;
import kpersistence.repository.TypoTableRepository;
import domain.repositories.orders.OrderSubjectTypesConsumablesRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderSubjectTypesConsumablesService")
public class OrderSubjectTypesConsumablesService extends TypoTableService<OrderSubjectTypesConsumables> {

    @Autowired
    OrderSubjectTypesConsumablesRepository repository;
    @Override
    protected TypoTableRepository<OrderSubjectTypesConsumables> getRepository() {
        return repository;
    }

}
