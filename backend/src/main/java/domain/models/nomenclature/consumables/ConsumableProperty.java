package domain.models.nomenclature.consumables;

import kpersistence.v2.annotations.Foreign2;
import rest.v2.models.JsonNonNullUserIdStringIdTable;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

@Table(name = "CONSUMABLE_PROPERTIES")
public class ConsumableProperty extends JsonNonNullUserIdStringIdTable {

    public static ConsumableProperty defaultProperty() {
        ConsumableProperty dp = new ConsumableProperty();
        dp.propertyName = "комментарий";
        return dp;
    }

    @Column(name = "TYPE_ID", foreign = ConsumableType.class)
    private String typeId;

    @Foreign2
    private ConsumableType consumableType;

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

    public ConsumableType getConsumableType() {
        return consumableType;
    }

    public void setConsumableType(ConsumableType consumableType) {
        this.consumableType = consumableType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
