package domain.repositories.orders;

import domain.models.orders.OrderSubjectTypeWithConsumableItemsView;
import kpersistence.repository.TypoViewRepository;
import org.springframework.stereotype.Repository;

@Repository
public class OrderSubjectTypeWithConsumableItemsViewRepository extends TypoViewRepository<OrderSubjectTypeWithConsumableItemsView> {

    public OrderSubjectTypeWithConsumableItemsViewRepository() {
        super(OrderSubjectTypeWithConsumableItemsView.class);
    }
}
