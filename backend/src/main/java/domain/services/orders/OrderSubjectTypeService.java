package domain.services.orders;

import domain.models.orders.OrderSubjectType;
import domain.repositories.orders.OrderSubjectTypeRepository;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AbstractTableRepository;
import service.AbstractTableService;

@Service("orderSubjectTypeService")
public class OrderSubjectTypeService extends AbstractTableService<OrderSubjectType> implements TypoServiceUser {

    @Autowired
    OrderSubjectTypeRepository repository;

    @Override
    protected AbstractTableRepository<OrderSubjectType> getRepository() {
        return repository;
    }

}
