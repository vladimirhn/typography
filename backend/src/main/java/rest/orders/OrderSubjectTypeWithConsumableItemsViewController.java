package rest.orders;

import domain.services.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order_subject_type_with_consumable_items_view")
public class OrderSubjectTypeWithConsumableItemsViewController implements TypoServiceUser {
}
