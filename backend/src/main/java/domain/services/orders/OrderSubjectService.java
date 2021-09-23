package domain.services.orders;

import domain.models.orders.*;
import domain.services.abstracts.TypoServiceUser;
import kcollections.CollectionFactory;
import kcollections.KList;
import repository.AbstractTableRepository;
import domain.repositories.orders.OrderSubjectRepository;
import rest.response.TableDataResponse;
import service.AbstractTableService;
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

                    orderSubject.setRelatedParentJsonConsumableItems(
                            viewLines
                                    .filterTrue(OrderSubjectWithConsumableItemsView::getParent)
                                    .mapEachBy(OrderSubjectWithConsumableItemsView::extractJsonConsumableItem)
                    );

                    orderSubject.setRelatedOwnJsonConsumableItems(
                            viewLines
                                    .filterFalse(OrderSubjectWithConsumableItemsView::getParent)
                                    .mapEachBy(OrderSubjectWithConsumableItemsView::extractJsonConsumableItem)
                    );
                    result.add(orderSubject);
                });

        return result;
    }

    public void add(OrderSubject item) {
        String newOrdSubjId = repository.insert(item);
        if (item.getRelatedOwnJsonConsumableItems() != null) {
            item.getRelatedOwnJsonConsumableItems().forEach(jsonConsumableItem -> {
                String consItemId = jsonConsumableItem.getItemId();
                if (consItemId.startsWith("+")) consItemId = consItemId.substring(1);
                orderSubjectConsumablesService.insert(new OrderSubjectConsumables(newOrdSubjId, consItemId));
            });
        }
    }

    public void update(OrderSubject item) {
        super.update(item);
        item.getRelatedOwnJsonConsumableItems().forEach(consumableItem -> {
            if (consumableItem.getItemId() != null && consumableItem.getItemId().startsWith("-")) {
                orderSubjectConsumablesService
                        .deleteSimilar(new OrderSubjectConsumables(item.getId(), consumableItem.getItemId().substring(1)));
            }

            if (consumableItem.getItemId() != null && consumableItem.getItemId().startsWith("+")) {
                orderSubjectConsumablesService
                        .insert(new OrderSubjectConsumables(item.getId(), consumableItem.getItemId().substring(1)));
            }
        });
    }

    public void delete(String id) {
        repository.delete(id);
        orderSubjectConsumablesService.deleteByField(OrderSubjectConsumables::setOrderSubjectId, id);
    }
}
