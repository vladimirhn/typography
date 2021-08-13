package domain.models.nomenclature.consumables;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "CONSUMABLE_PROPERTIES_VALUES")
public class ConsumablePropertyValue extends TypoTable {

    @Column(name = "ITEM_ID")
    private String itemId;

    @Column(name = "PROPERTY_ID")
    private String propertyId;

    @Column(name = "PROPERTY_VALUE")
    private String propertyValue;

    public ConsumablePropertyValue() {}

    @Override
    public void setDefaults() {}

    public ConsumablePropertyValue(String newId, String itemId, String propertyId, String propertyValue) {
        setId(newId);
        this.itemId = itemId;
        this.propertyId = propertyId;
        this.propertyValue = propertyValue;
    }

    public ConsumablePropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
