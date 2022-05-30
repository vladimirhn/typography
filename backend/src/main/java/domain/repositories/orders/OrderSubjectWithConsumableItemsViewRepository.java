package domain.repositories.orders;

import domain.models.orders.OrderSubjectWithConsumableItemsView;
import org.springframework.stereotype.Repository;
import repository.v1.AbstractViewRepository;

@Repository
public class OrderSubjectWithConsumableItemsViewRepository extends AbstractViewRepository<OrderSubjectWithConsumableItemsView> {

    public OrderSubjectWithConsumableItemsViewRepository() {
        super(OrderSubjectWithConsumableItemsView.class);
    }
}
