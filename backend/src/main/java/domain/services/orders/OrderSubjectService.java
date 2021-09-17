package domain.services.orders;

import domain.models.orders.OrderSubject;
import repository.TypoTableRepository;
import domain.repositories.orders.OrderSubjectRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderSubjectService")
public class OrderSubjectService extends TypoTableService<OrderSubject> {

    @Autowired
    OrderSubjectRepository repository;
    @Override
    protected TypoTableRepository<OrderSubject> getRepository() {
        return repository;
    }

}
