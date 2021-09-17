package domain.repositories.orders;

import domain.models.orders.OrderSubjectTypeWithConsumableItemsView;
import repository.AbstractViewRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderSubjectTypeWithConsumableItemsViewRepository extends AbstractViewRepository<OrderSubjectTypeWithConsumableItemsView> {

    public OrderSubjectTypeWithConsumableItemsViewRepository() {
        super(OrderSubjectTypeWithConsumableItemsView.class);
    }
}
