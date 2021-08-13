package domain.services;

import domain.services.application.IdService;
import domain.services.defaults.consumables.ConsumablesDefaultsService;
import domain.services.nomenclature.consumables.ConsumableItemsService;
import domain.services.nomenclature.consumables.ConsumablePropertiesValuesService;
import domain.services.nomenclature.consumables.ConsumableTypesService;
import domain.services.nomenclature.consumables.ConsumablesService;
import domain.services.nomenclature.equipment.EquipmentTypesService;
import domain.services.purchasing.PurchasingConsumablesService;

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

    //I
    IdService idService = getBean(IdService.class);

    //E
    EquipmentTypesService equipmentTypesService = getBean(EquipmentTypesService.class);

    //P
    PurchasingConsumablesService purchasingConsumablesService = getBean(PurchasingConsumablesService.class);
}
