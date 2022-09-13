package domain.services.orders;

import domain.models.orders.OrderSubject;
import domain.models.orders.OrderSubjectConsumables;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.stereotype.Service;
import service.v2.AbstractStringIdTableService;

@Service()
public class OrderSubjectService extends AbstractStringIdTableService<OrderSubject> implements TypoServiceUser {

    public void add(OrderSubject item) {
        String newOrdSubjId = repository().insert(item);
        if (item.getRelatedOwnConsumableItems() != null) {
            item.getRelatedOwnConsumableItems().forEach(consumableItemData -> {
                String consItemId = consumableItemData.getId();
                if (consItemId.startsWith("+")) consItemId = consItemId.substring(1);
                orderSubjectConsumablesService.insert(new OrderSubjectConsumables(newOrdSubjId, consItemId));
            });
        }
    }

    public void update(OrderSubject item) {
        super.update(item);
    }

    public String delete(String id) {
        orderSubjectConsumablesService.deleteByField(OrderSubjectConsumables::setOrderSubjectId, id);
        return repository().delete(id);
    }
}
