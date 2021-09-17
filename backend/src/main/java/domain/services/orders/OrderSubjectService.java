package domain.services.orders;

import domain.models.orders.OrderSubject;
import repository.AbstractTableRepository;
import domain.repositories.orders.OrderSubjectRepository;
import service.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderSubjectService")
public class OrderSubjectService extends TypoTableService<OrderSubject> {

    @Autowired
    OrderSubjectRepository repository;
    @Override
    protected AbstractTableRepository<OrderSubject> getRepository() {
        return repository;
    }

}
