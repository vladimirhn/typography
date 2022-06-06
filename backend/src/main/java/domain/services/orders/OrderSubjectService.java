package domain.services.orders;

import domain.models.orders.OrderSubject;
import domain.models.orders.OrderSubjectConsumables;
import domain.repositories.orders.OrderSubjectRepository;
import domain.services.abstracts.TypoServiceUser;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.v1.AbstractTableRepository;
import service.v1.AbstractTableService;

@Service("orderSubjectService")
public class OrderSubjectService extends AbstractTableService<OrderSubject> implements TypoServiceUser {

    @Autowired
    OrderSubjectRepository repository;
    @Override
    protected AbstractTableRepository<OrderSubject> getRepository() {
        return repository;
    }

    public KList<OrderSubject> getAll() {
        return super.selectAll();
    }

    public void add(OrderSubject item) {
        String newOrdSubjId = repository.insert(item);
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

    public void delete(String id) {
        repository.delete(id);
        orderSubjectConsumablesService.deleteByField(OrderSubjectConsumables::setOrderSubjectId, id);
    }
}
