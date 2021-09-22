package domain.services.abstracts;

import application.ServiceUser;
import domain.services.abstracts.response.TypoDictionaryService;
import domain.services.defaults.consumables.ConsumablesDefaultsService;
import domain.services.nomenclature.consumables.ConsumableItemsService;
import domain.services.nomenclature.consumables.ConsumablePropertiesValuesService;
import domain.services.nomenclature.consumables.ConsumableTypesService;
import domain.services.nomenclature.consumables.ConsumablesService;
import domain.services.nomenclature.equipment.EquipmentTypesService;
import domain.services.orders.*;
import domain.services.purchasing.PurchasingConsumablesService;
import domain.services.stock.StockBalanceService;
import domain.services.stock.StockService;

public interface TypoServiceUser extends ServiceUser {

    //C
    ConsumablePropertiesValuesService consumablePropertiesValuesService = ServiceUser.getBean(ConsumablePropertiesValuesService.class);
    ConsumablesDefaultsService defaultsService = ServiceUser.getBean(ConsumablesDefaultsService.class);
    ConsumablesService consumablesService = ServiceUser.getBean(ConsumablesService.class);
    ConsumableItemsService consumableItemsService = ServiceUser.getBean(ConsumableItemsService.class);
    ConsumableTypesService consumableTypesService = ServiceUser.getBean(ConsumableTypesService.class);

    //D
    TypoDictionaryService typoDictionaryService = ServiceUser.getBean(TypoDictionaryService.class);

    //I

    //E
    EquipmentTypesService equipmentTypesService = ServiceUser.getBean(EquipmentTypesService.class);

    //O
    OrderService orderService = ServiceUser.getBean(OrderService.class);
    OrderSubjectConsumablesService orderSubjectConsumablesService = ServiceUser.getBean(OrderSubjectConsumablesService.class);
    OrderSubjectService orderSubjectService = ServiceUser.getBean(OrderSubjectService.class);
    OrderSubjectTypeService orderSubjectTypeService = ServiceUser.getBean(OrderSubjectTypeService.class);
    OrderSubjectTypesConsumablesService orderSubjectTypesConsumablesService = ServiceUser.getBean(OrderSubjectTypesConsumablesService.class);
    OrderSubjectWithConsumableItemsViewService orderSubjectWithConsumableItemsViewService = ServiceUser.getBean(OrderSubjectWithConsumableItemsViewService.class);

    //P
    PurchasingConsumablesService purchasingConsumablesService = ServiceUser.getBean(PurchasingConsumablesService.class);

    //S
    StockBalanceService stockBalanceService = ServiceUser.getBean(StockBalanceService.class);
    StockService stockService = ServiceUser.getBean(StockService.class);
}
