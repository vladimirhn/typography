package domain.services.orders;

import domain.models.orders.OrderSubjectTypeWithConsumableItemsView;
import domain.repositories.orders.OrderSubjectTypeWithConsumableItemsViewRepository;
import domain.services.abstracts.TypoViewService;
import repository.TypoViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderSubjectTypeWithConsumableItemsViewService")
public class OrderSubjectTypeWithConsumableItemsViewService extends TypoViewService<OrderSubjectTypeWithConsumableItemsView> {

    @Autowired
    OrderSubjectTypeWithConsumableItemsViewRepository repository;

    @Override
    protected TypoViewRepository<OrderSubjectTypeWithConsumableItemsView> getRepository() {
        return repository;
    }
}
