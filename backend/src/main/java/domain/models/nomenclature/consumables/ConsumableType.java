package domain.models.nomenclature.consumables;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "CONSUMABLE_TYPES")
public class ConsumableType extends TypoTable {

//    SELECT CT.ID                TYPE_ID,
//    TYPE                 TYPE_NAME,
//    CI.ID                ITEM_ID,
//    DESCRIPTION          ITEM_DESCRIPTION,
//    CP.ID                PROPERTY_ID,
//    PROPERTY_NAME        PROPERTY_NAME,
//    PROPERTY_MEASURE     PROPERTY_MEASURE,
//    CPV.ID               VALUE_ID,
//    CPV.PROPERTY_VALUE   VALUE_VALUE
//    FROM CONSUMABLE_TYPES CT
//    LEFT JOIN CONSUMABLE_ITEMS CI on CT.ID = CI.TYPE_ID
//    LEFT JOIN CONSUMABLE_PROPERTIES CP on CI.TYPE_ID = CP.TYPE_ID
//    LEFT JOIN CONSUMABLE_PROPERTIES_VALUES CPV on CP.ID = CPV.PROPERTY_ID

    @Column(name = "TYPE")
    private String type;

    private Map<Integer, String> properties = new HashMap<>();

    private List<?> consumableItems = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<Integer, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<Integer, String> properties) {
        this.properties = properties;
    }

    public List<?> getConsumableItems() {
        return consumableItems;
    }

    public void setConsumableItems(List<?> consumableItems) {
        this.consumableItems = consumableItems;
    }
}
