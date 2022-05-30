package rest.orders;

import domain.models.orders.OrderSubjectWithConsumableItemsView;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoViewController;
import service.v1.AbstractViewService;

@RestController
@RequestMapping("/order_subject_with_consumable_items_view")
public class OrderSubjectWithConsumableItemsViewController extends TypoViewController<OrderSubjectWithConsumableItemsView> implements TypoServiceUser {

    @Override
    protected AbstractViewService<OrderSubjectWithConsumableItemsView> getService() {
        return orderSubjectWithConsumableItemsViewService;
    }
}
