package domain.services.orders;

import domain.models.orders.Order;
import domain.models.orders.OrderWithSubjectWithConsumablesView;
import domain.repositories.orders.OrderRepository;
import domain.services.abstracts.TypoServiceUser;
import kcollections.CollectionFactory;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AbstractTableRepository;
import service.AbstractTableService;

import java.util.List;

@Service("orderService")
public class OrderService extends AbstractTableService<Order> implements TypoServiceUser {

    @Autowired
    OrderRepository repository;
    @Override
    protected AbstractTableRepository<Order> getRepository() {
        return repository;
    }

    public KList<Order> getAll() {

        KList<Order> result = CollectionFactory.makeList();

        List<OrderWithSubjectWithConsumablesView> all = orderWithSubjectWithConsumablesViewService
                .selectAll();

        orderWithSubjectWithConsumablesViewService
                .selectAll()
                .groupBy(OrderWithSubjectWithConsumablesView::extractOrder)
                .forEach((order, lines) -> {
                    order.setRelatedConsumables(lines.mapEachBy(OrderWithSubjectWithConsumablesView::extractMinimalConsumableItemData));
                    result.add(order);
                });

        return result;
    }
}
