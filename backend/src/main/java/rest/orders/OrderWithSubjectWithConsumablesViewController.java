package rest.orders;

import domain.models.orders.OrderWithSubjectWithConsumablesView;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.abstracts.TypoViewController;
import service.v1.AbstractViewService;

@RestController
@RequestMapping("/order_with_subject_with_consumables_view")
public class OrderWithSubjectWithConsumablesViewController extends TypoViewController<OrderWithSubjectWithConsumablesView> implements TypoServiceUser {

    @Override
    protected AbstractViewService<OrderWithSubjectWithConsumablesView> getService() {
        return orderWithSubjectWithConsumablesViewService;
    }
}
