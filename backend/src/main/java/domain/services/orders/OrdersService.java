package domain.services.orders;

import domain.models.orders.Order;
import org.springframework.stereotype.Service;
import service.v2.AbstractStringIdTableService;

@Service
public class OrdersService extends AbstractStringIdTableService<Order> {
}
