package domain.services.orders;

import domain.models.orders.Order;
import repository.AbstractTableRepository;
import domain.repositories.orders.OrderRepository;
import service.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService extends TypoTableService<Order> {

    @Autowired
    OrderRepository repository;
    @Override
    protected AbstractTableRepository<Order> getRepository() {
        return repository;
    }

}
