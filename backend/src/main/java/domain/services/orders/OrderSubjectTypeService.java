package domain.services.orders;

import domain.models.orders.OrderSubjectType;
import domain.repositories.abstracts.TypoTableRepository;
import domain.repositories.orders.OrderSubjectTypeRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderSubjectTypeService")
public class OrderSubjectTypeService extends TypoTableService<OrderSubjectType> {

    @Autowired
    OrderSubjectTypeRepository repository;
    @Override
    protected TypoTableRepository<OrderSubjectType> getRepository() {
        return repository;
    }

}
