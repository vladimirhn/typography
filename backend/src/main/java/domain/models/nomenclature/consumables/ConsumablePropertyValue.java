package domain.models.nomenclature.consumables;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "CONSUMABLE_PROPERTIES_VALUES")
public class ConsumablePropertyValue extends TypoTable {

    @Column(name = "ITEM_ID")
    private Long typeId;

    @Column(name = "PROPERTY_ID")
    private Long propertyId;

    @Column(name = "PROPERTY_VALUE")
    private String propertyValue;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
