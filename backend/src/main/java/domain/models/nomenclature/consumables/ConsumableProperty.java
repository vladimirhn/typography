package domain.models.nomenclature.consumables;

import rest.v2.models.JsonNonNullUserIdStringIdTable;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

@Entity
@Table(name = "CONSUMABLE_PROPERTIES")
public class ConsumableProperty extends JsonNonNullUserIdStringIdTable {

    @Column(name = "TYPE_ID")
    private String typeId;

    @Column(name = "PROPERTY_NAME")
    private String propertyName;

    public ConsumableProperty() {}

    @Override
    public void setDefaults() {}

    public ConsumableProperty(String propertyName) {
        this.propertyName = propertyName;
    }

    public ConsumableProperty(String propertyName, String typeId) {
        this.typeId = typeId;
        this.propertyName = propertyName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
