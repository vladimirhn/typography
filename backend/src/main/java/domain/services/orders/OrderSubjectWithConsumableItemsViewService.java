package domain.services.orders;

import domain.models.orders.OrderSubjectWithConsumableItemsView;
import domain.repositories.orders.OrderSubjectWithConsumableItemsViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AbstractViewRepository;
import service.AbstractViewService;

@Service("orderSubjectWithConsumableItemsViewService")
public class OrderSubjectWithConsumableItemsViewService extends AbstractViewService<OrderSubjectWithConsumableItemsView> {

    @Autowired
    OrderSubjectWithConsumableItemsViewRepository repository;

    @Override
    protected AbstractViewRepository<OrderSubjectWithConsumableItemsView> getRepository() {
        return repository;
    }
}
