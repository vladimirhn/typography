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

    @Column(name = "ITEM_DESCRIPTION")
    private String itemDescription;

    @Column(name = "PROPERTY_ID")
    private Long propertyId;

    @Column(name = "PROPERTY_NAME")
    private String propertyName;

    @Column(name = "PROPERTY_MEASURE")
    private String propertyMeasure;

    @Column(name = "VALUE_ID")
    private Long valueId;

    @Column(name = "VALUE_VALUE")
    private Long valueValue;

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

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
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

    public String getPropertyMeasure() {
        return propertyMeasure;
    }

    public void setPropertyMeasure(String propertyMeasure) {
        this.propertyMeasure = propertyMeasure;
    }

    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    public Long getValueValue() {
        return valueValue;
    }

    public void setValueValue(Long valueValue) {
        this.valueValue = valueValue;
    }
}
