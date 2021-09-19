package domain.services.orders;

import domain.models.orders.OrderSubjectTypeWithConsumableItemsView;
import domain.repositories.orders.OrderSubjectTypeWithConsumableItemsViewRepository;
import service.AbstractViewService;
import repository.AbstractViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderSubjectTypeWithConsumableItemsViewService")
public class OrderSubjectTypeWithConsumableItemsViewService extends AbstractViewService<OrderSubjectTypeWithConsumableItemsView> {

    @Autowired
    OrderSubjectTypeWithConsumableItemsViewRepository repository;

    @Override
    protected AbstractViewRepository<OrderSubjectTypeWithConsumableItemsView> getRepository() {
        return repository;
    }
}
