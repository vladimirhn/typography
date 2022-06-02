package domain.services.abstracts;

import application.ServiceUser;
import domain.services.counterparties.LegalEntitiesService;
import domain.services.defaults.consumables.ConsumablesDefaultsService;
import domain.services.enterprises.FinancialTransactionsViewService;
import domain.services.enterprises.EnterprisesService;
import domain.services.enterprises.MoneyMovenetsService;
import domain.services.nomenclature.consumables.*;
import domain.services.nomenclature.equipment.EquipmentTypesService;
import domain.services.orders.*;
import domain.services.purchasing.PurchasingConsumablesService;
import domain.services.stock.OrderConsumedConsumablesBalanceViewService;
import domain.services.stock.PurchasedConsumablesBalanceViewService;
import domain.services.stock.StockBalanceService;
import domain.services.stock.StockService;

public interface TypoServiceUser extends ServiceUser {

    //A
    FinancialTransactionsViewService financialTransactionsViewService = ServiceUser.getBean(FinancialTransactionsViewService.class);

    //C
    ConsumablePropertiesValuesService consumablePropertiesValuesService = ServiceUser.getBean(ConsumablePropertiesValuesService.class);
    ConsumablesDefaultsService defaultsService = ServiceUser.getBean(ConsumablesDefaultsService.class);
    ConsumablesService consumablesService = ServiceUser.getBean(ConsumablesService.class);
    ConsumableItemsService consumableItemsService = ServiceUser.getBean(ConsumableItemsService.class);
    ConsumableItems2Service consumableItems2Service = ServiceUser.getBean(ConsumableItems2Service.class);
    ConsumableTypesService consumableTypesService = ServiceUser.getBean(ConsumableTypesService.class);

    //D

    //L
    LegalEntitiesService legalEntitiesService = ServiceUser.getBean(LegalEntitiesService.class);

    //E
    EquipmentTypesService equipmentTypesService = ServiceUser.getBean(EquipmentTypesService.class);
    EnterprisesService enterprisesService = ServiceUser.getBean(EnterprisesService.class);

    //M
    MoneyMovenetsService moneyMovenetsService = ServiceUser.getBean(MoneyMovenetsService.class);

    //O
    OrderConsumableService orderConsumableService = ServiceUser.getBean(OrderConsumableService.class);
    OrderConsumedConsumablesBalanceViewService orderConsumedConsumablesBalanceViewService = ServiceUser.getBean(OrderConsumedConsumablesBalanceViewService.class);
    OrderSubjectConsumablesService orderSubjectConsumablesService = ServiceUser.getBean(OrderSubjectConsumablesService.class);
    OrderSubjectService orderSubjectService = ServiceUser.getBean(OrderSubjectService.class);
    OrderSubjectTypeService orderSubjectTypeService = ServiceUser.getBean(OrderSubjectTypeService.class);
    OrderSubjectWithConsumableItemsViewService orderSubjectWithConsumableItemsViewService = ServiceUser.getBean(OrderSubjectWithConsumableItemsViewService.class);

    //P
    ParameterService parameterService = ServiceUser.getBean(ParameterService.class);
    PurchasedConsumablesBalanceViewService purchasedConsumablesBalanceViewService = ServiceUser.getBean(PurchasedConsumablesBalanceViewService.class);
    PurchasingConsumablesService purchasingConsumablesService = ServiceUser.getBean(PurchasingConsumablesService.class);

    //S
    StockBalanceService stockBalanceService = ServiceUser.getBean(StockBalanceService.class);
    StockService stockService = ServiceUser.getBean(StockService.class);
}
