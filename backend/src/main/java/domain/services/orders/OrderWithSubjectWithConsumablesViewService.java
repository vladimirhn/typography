package domain.services.orders;

import domain.models.orders.OrderWithSubjectWithConsumablesView;
import domain.repositories.orders.OrderWithSubjectWithConsumablesViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AbstractViewRepository;
import service.AbstractViewService;

@Service("orderWithSubjectWithConsumablesViewService")
public class OrderWithSubjectWithConsumablesViewService extends AbstractViewService<OrderWithSubjectWithConsumablesView> {

    @Autowired
    OrderWithSubjectWithConsumablesViewRepository repository;

    @Override
    protected AbstractViewRepository<OrderWithSubjectWithConsumablesView> getRepository() {
        return repository;
    }
}
