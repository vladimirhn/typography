package domain.services;

import domain.services.application.IdService;
import domain.services.nomenclature.consumables.ConsumablePropertiesValuesService;
import domain.services.nomenclature.consumables.ConsumableTypesService;
import domain.services.nomenclature.equipment.EquipmentTypesService;
import domain.services.purchasing.PurchasingConsumablesService;

public interface ServiceUser {

    static <T> T getBean(Class<T> beanClass) {
        return ContextProvider.getContext().getBean(beanClass);
    }

    //C
    ConsumablePropertiesValuesService consumablePropertiesValuesService = getBean(ConsumablePropertiesValuesService.class);
    ConsumableTypesService consumableTypesService = getBean(ConsumableTypesService.class);

    //I
    IdService idService = getBean(IdService.class);

    //E
    EquipmentTypesService equipmentTypesService = getBean(EquipmentTypesService.class);

    //P
    PurchasingConsumablesService purchasingConsumablesService = getBean(PurchasingConsumablesService.class);
}
