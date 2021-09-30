package domain.repositories.orders;

import domain.models.orders.OrderWithSubjectWithConsumablesView;
import org.springframework.stereotype.Repository;
import repository.AbstractViewRepository;

@Repository
public class OrderWithSubjectWithConsumablesViewRepository extends AbstractViewRepository<OrderWithSubjectWithConsumablesView> {

    public OrderWithSubjectWithConsumablesViewRepository() {
        super(OrderWithSubjectWithConsumablesView.class);
    }
}
