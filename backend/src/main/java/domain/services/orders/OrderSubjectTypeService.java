package domain.services.orders;

import domain.models.orders.OrderSubjectType;
import domain.models.orders.OrderSubjectTypeWithConsumableItemsView;
import domain.models.orders.OrderSubjectTypesConsumables;
import kcollections.CollectionFactory;
import kpersistence.repository.TypoTableRepository;
import domain.repositories.orders.OrderSubjectTypeRepository;
import domain.services.ServiceUser;
import domain.services.abstracts.TypoTableService;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderSubjectTypeService")
public class OrderSubjectTypeService extends TypoTableService<OrderSubjectType> implements ServiceUser {

    @Autowired
    OrderSubjectTypeRepository repository;

    @Autowired
    OrderSubjectTypeWithConsumableItemsViewService orderSubjectTypeWithConsumableItemsViewService;

    @Autowired
    OrderSubjectTypesConsumablesService orderSubjectTypesConsumablesService;

    @Override
    protected TypoTableRepository<OrderSubjectType> getRepository() {
        return repository;
    }

    public KList<OrderSubjectType> getAll() {
        KList<OrderSubjectType> result = CollectionFactory.makeList();
        KList<OrderSubjectTypeWithConsumableItemsView> viewData = orderSubjectTypeWithConsumableItemsViewService.selectAll();
        viewData
                .groupBy(OrderSubjectTypeWithConsumableItemsView::getOrderSubjectType)
                .forEach((orderSubjectType, relatedSubList) -> {
                    orderSubjectType.setRelatedJsonConsumableItems(relatedSubList.mapEachBy(OrderSubjectTypeWithConsumableItemsView::getJsonConsumableItem));
                    result.add(orderSubjectType);
                });

        return result;
    }

    public void add(OrderSubjectType item) {
        String newTypeId = repository.insert(item);
        if (item.getRelatedJsonConsumableItems() != null) {
            item.getRelatedJsonConsumableItems().forEach(jsonConsumableItem -> {
                String consItemId = jsonConsumableItem.getItemId();
                if (consItemId.startsWith("+")) consItemId = consItemId.substring(1);
                orderSubjectTypesConsumablesService.insert(new OrderSubjectTypesConsumables(newTypeId, consItemId));
            });
        }
    }

    public void update(OrderSubjectType item) {
        super.update(item);
        item.getRelatedJsonConsumableItems().forEach(consumableItem -> {
            if (consumableItem.getItemId() != null && consumableItem.getItemId().startsWith("-")) {
                orderSubjectTypesConsumablesService
                        .deleteSimilar(new OrderSubjectTypesConsumables(item.getId(), consumableItem.getItemId().substring(1)));
            }

            if (consumableItem.getItemId() != null && consumableItem.getItemId().startsWith("+")) {
                orderSubjectTypesConsumablesService
                        .insert(new OrderSubjectTypesConsumables(item.getId(), consumableItem.getItemId().substring(1)));
            }
        });
    }

    public void delete(String id) {
        repository.delete(id);
        orderSubjectTypesConsumablesService.deleteByField(OrderSubjectTypesConsumables::setOrderSubjectTypeId, id);
    }
}
