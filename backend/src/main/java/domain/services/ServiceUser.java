package domain.services;

import domain.services.abstracts.response.DictionaryService;
import domain.services.application.IdService;
import domain.services.defaults.consumables.ConsumablesDefaultsService;
import domain.services.nomenclature.consumables.ConsumableItemsService;
import domain.services.nomenclature.consumables.ConsumablePropertiesValuesService;
import domain.services.nomenclature.consumables.ConsumableTypesService;
import domain.services.nomenclature.consumables.ConsumablesService;
import domain.services.nomenclature.equipment.EquipmentTypesService;
import domain.services.orders.OrderService;
import domain.services.orders.OrderSubjectService;
import domain.services.purchasing.PurchasingConsumablesService;
import domain.services.stock.StockBalanceService;
import domain.services.stock.StockService;

public interface ServiceUser {

    static <T> T getBean(Class<T> beanClass) {
        return ContextProvider.getContext().getBean(beanClass);
    }

    //C
    ConsumablePropertiesValuesService consumablePropertiesValuesService = getBean(ConsumablePropertiesValuesService.class);
    ConsumablesDefaultsService defaultsService = getBean(ConsumablesDefaultsService.class);
    ConsumablesService consumablesService = getBean(ConsumablesService.class);
    ConsumableItemsService consumableItemsService = getBean(ConsumableItemsService.class);
    ConsumableTypesService consumableTypesService = getBean(ConsumableTypesService.class);

    //D
    DictionaryService dictionaryService = getBean(DictionaryService.class);

    //I
    IdService idService = getBean(IdService.class);

    //E
    EquipmentTypesService equipmentTypesService = getBean(EquipmentTypesService.class);

    //O
    OrderService orderService = getBean(OrderService.class);
    OrderSubjectService orderSubjectService = getBean(OrderSubjectService.class);

    //P
    PurchasingConsumablesService purchasingConsumablesService = getBean(PurchasingConsumablesService.class);

    //S
    StockBalanceService stockBalanceService = getBean(StockBalanceService.class);
    StockService stockService = getBean(StockService.class);
}
