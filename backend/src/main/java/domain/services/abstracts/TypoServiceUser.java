package domain.services.abstracts;

import application.ServiceUser;
import domain.services.nomenclature.consumables.ConsumableItems2Service;
import domain.services.nomenclature.consumables.ConsumablePropertiesService;
import domain.services.nomenclature.consumables.ConsumablePropertiesValuesService;
import domain.services.orders.OrderConsumedConsumablesBalanceViewService;
import domain.services.orders.OrderSubjectService;
import domain.services.purchasing.PurchasedConsumablesBalanceViewService;
import domain.services.stock.StockBalanceService;

public interface TypoServiceUser extends ServiceUser {

    //C
    ConsumableItems2Service consumableItems2Service = ServiceUser.getBean(ConsumableItems2Service.class);
    ConsumablePropertiesService consumablePropertiesService = ServiceUser.getBean(ConsumablePropertiesService.class);
    ConsumablePropertiesValuesService consumablePropertiesValuesService = ServiceUser.getBean(ConsumablePropertiesValuesService.class);


    //O
    OrderConsumedConsumablesBalanceViewService orderConsumedConsumablesBalanceViewService = ServiceUser.getBean(OrderConsumedConsumablesBalanceViewService.class);
    OrderSubjectService orderSubjectService = ServiceUser.getBean(OrderSubjectService.class);


    //P
    PurchasedConsumablesBalanceViewService purchasedConsumablesBalanceViewService = ServiceUser.getBean(PurchasedConsumablesBalanceViewService.class);


    //S
    StockBalanceService stockBalanceService = ServiceUser.getBean(StockBalanceService.class);

}