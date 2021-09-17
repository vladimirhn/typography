package domain.services.orders;

import domain.models.orders.Order;
import kpersistence.repository.TypoTableRepository;
import domain.repositories.orders.OrderRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService extends TypoTableService<Order> {

    @Autowired
    OrderRepository repository;
    @Override
    protected TypoTableRepository<Order> getRepository() {
        return repository;
    }

}
