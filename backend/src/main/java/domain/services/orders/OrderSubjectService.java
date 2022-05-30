package domain.services.orders;

import domain.models.orders.*;
import domain.services.abstracts.TypoServiceUser;
import kcollections.CollectionFactory;
import kcollections.KList;
import repository.v1.AbstractTableRepository;
import domain.repositories.orders.OrderSubjectRepository;
import service.v1.AbstractTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderSubjectService")
public class OrderSubjectService extends AbstractTableService<OrderSubject> implements TypoServiceUser {

    @Autowired
    OrderSubjectRepository repository;
    @Override
    protected AbstractTableRepository<OrderSubject> getRepository() {
        return repository;
    }

    public KList<OrderSubject> getAll() {

        KList<OrderSubject> result = CollectionFactory.makeList();

        orderSubjectWithConsumableItemsViewService.selectAll()
                .groupBy(OrderSubjectWithConsumableItemsView::extractOrderSubject)
                .forEach((orderSubject, viewLines) -> {

                    orderSubject.setRelatedOwnConsumableItems(
                            viewLines.mapEachBy(OrderSubjectWithConsumableItemsView::extractMinimalConsumableItemData)
                    );
                    result.add(orderSubject);
                });

        return result;
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
        item.getRelatedOwnConsumableItems().forEach(consumableItemData -> {
            if (consumableItemData.getId() != null && consumableItemData.getId().startsWith("-")) {
                orderSubjectConsumablesService
                        .deleteSimilar(new OrderSubjectConsumables(item.getId(), consumableItemData.getId().substring(1)));
            }

            if (consumableItemData.getId() != null && consumableItemData.getId().startsWith("+")) {
                orderSubjectConsumablesService
                        .insert(new OrderSubjectConsumables(item.getId(), consumableItemData.getId().substring(1)));
            }
        });
    }

    public void delete(String id) {
        repository.delete(id);
        orderSubjectConsumablesService.deleteByField(OrderSubjectConsumables::setOrderSubjectId, id);
    }
}
