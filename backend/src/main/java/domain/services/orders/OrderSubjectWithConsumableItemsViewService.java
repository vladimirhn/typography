package domain.services.orders;

import domain.models.orders.OrderSubjectWithConsumableItemsView;
import domain.repositories.orders.OrderSubjectWithConsumableItemsViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.v1.AbstractViewRepository;
import service.v1.AbstractViewService;

@Service("orderSubjectWithConsumableItemsViewService")
public class OrderSubjectWithConsumableItemsViewService extends AbstractViewService<OrderSubjectWithConsumableItemsView> {

    @Autowired
    OrderSubjectWithConsumableItemsViewRepository repository;

    @Override
    protected AbstractViewRepository<OrderSubjectWithConsumableItemsView> getRepository() {
        return repository;
    }
}
