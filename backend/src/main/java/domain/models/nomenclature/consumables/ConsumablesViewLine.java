package domain.models.nomenclature.consumables;

import domain.models.abstracts.TypoView;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "ALL_CONSUMABLES_VIEW")
public class ConsumablesViewLine extends TypoView {

    @Column(name = "TYPE_ID")
    private Long typeId;

    @Column(name = "TYPE_NAME")
    private String typeName;

    @Column(name = "ITEM_ID")
    private Long itemId;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "PROPERTY_ID")
    private Long propertyId;

    @Column(name = "PROPERTY_NAME")
    private String propertyName;

    @Column(name = "VALUE_ID")
    private Long valueId;

    @Column(name = "VALUE_VALUE")
    private String valueValue;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    public String getValueValue() {
        return valueValue;
    }

    public void setValueValue(String valueValue) {
        this.valueValue = valueValue;
    }
}
