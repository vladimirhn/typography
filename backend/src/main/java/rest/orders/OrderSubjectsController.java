package rest.orders;

import domain.models.orders.OrderSubject;
import domain.models.orders.OrderSubjectWithConsumableItemsView;
import domain.services.abstracts.TypoServiceUser;
import domain.services.orders.OrderSubjectWithConsumableItemsViewService;
import kcollections.CollectionFactory;
import kcollections.KList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoTableController;
import rest.response.TableDataResponse;
import service.AbstractTableService;

@RestController
@RequestMapping("/order_subjects")
public class OrderSubjectsController extends TypoTableController<OrderSubject> implements TypoServiceUser {

    @Override
    protected AbstractTableService<OrderSubject> getService() {
        return orderSubjectService;
    }

    @Autowired
    OrderSubjectWithConsumableItemsViewService orderSubjectWithConsumableItemsViewService;

    @Override
    public TableDataResponse<OrderSubject> getAll() {

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

        return getAllTranslatedResponse(result);
    }
}
