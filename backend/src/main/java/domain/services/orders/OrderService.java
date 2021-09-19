package domain.services.orders;

import domain.models.orders.Order;
import repository.AbstractTableRepository;
import domain.repositories.orders.OrderRepository;
import service.AbstractTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService extends AbstractTableService<Order> {

    @Autowired
    OrderRepository repository;
    @Override
    protected AbstractTableRepository<Order> getRepository() {
        return repository;
    }

}
