package domain.models;

import domain.models.nomenclature.consumables.ConsumableItem;
import domain.models.purchasing.PurchasingConsumables;
import kpersistence.domain.Tables;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TypoTables {

    public TypoTables() {
        Map<String, Class<?>> tables = new HashMap<>();

        tables.put(PurchasingConsumables.class.getSimpleName(), PurchasingConsumables.class);
        tables.put(ConsumableItem.class.getSimpleName(), ConsumableItem.class);

        Tables.setTables(tables);
    }
}
