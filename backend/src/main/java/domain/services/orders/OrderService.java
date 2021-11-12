package domain.services.orders;

import domain.models.orders.Order;
import domain.models.orders.OrderConsumable;
import domain.models.orders.OrderWithSubjectWithConsumablesView;
import domain.repositories.orders.OrderRepository;
import domain.services.abstracts.TypoServiceUser;
import kcollections.CollectionFactory;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AbstractTableRepository;
import service.AbstractTableService;

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

        orderWithSubjectWithConsumablesViewService.selectAll()
                .groupBy(OrderWithSubjectWithConsumablesView::extractOrder)
                .forEach((order, lines) -> {
                    order.setRelatedConsumables(lines.mapEachBy(OrderWithSubjectWithConsumablesView::extractOrderConsumable));
                    result.add(order);
                });

        result.sortDesc(Order::getOrderDate);

        return result;
    }

    public void add(Order data) {
        data.setStatus("CREATED");
        String newOrderId = orderService.insert(data);

        data.getRelatedConsumables()
                .useEachBy(OrderConsumable::denullifyQty)
                .useEachBy(OrderConsumable::negateQty)
                .forEach(consumable -> {
                    orderConsumableService.insert(new OrderConsumable(newOrderId, consumable.getId(), consumable.getQty()));
                });
    }

    public void update(Order data) {

        repository.update(data);
        data.getRelatedConsumables()
                .useEachBy(OrderConsumable::denullifyQty)
                .useEachBy(OrderConsumable::negateQty)
                .forEach(orderConsumableService::update);
    }

    public void delete(String id) {

        repository.delete(id);
        orderConsumableService.deleteByField(OrderConsumable::setOrderId, id);
    }
}
