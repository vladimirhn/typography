package domain.services;

import domain.services.nomenclature.consumables.ConsumableTypesService;
import domain.services.nomenclature.equipment.EquipmentTypesService;
import domain.services.purchasing.PurchasingConsumablesService;

public interface ServiceUser {

    static <T> T getBean(Class<T> beanClass) {
        return ContextProvider.getContext().getBean(beanClass);
    }

    //C
    ConsumableTypesService consumableTypesService = getBean(ConsumableTypesService.class);

    //E
    EquipmentTypesService equipmentTypesService = getBean(EquipmentTypesService.class);

    //P
    PurchasingConsumablesService purchasingConsumablesService = getBean(PurchasingConsumablesService.class);
}
