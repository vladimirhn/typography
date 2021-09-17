package domain.models.nomenclature.consumables;

import repository.tables.TypoView;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "ALL_CONSUMABLES_VIEW")
public class ConsumablesView extends TypoView {

    @Column(name = "TYPE_ID")
    private String typeId;

    @Column(name = "TYPE_NAME")
    private String typeName;

    @Column(name = "ITEM_ID")
    private String itemId;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "PACKAGE_CAPACITY")
    private BigDecimal packageCapacity;

    @Column(name = "PROPERTY_ID")
    private String propertyId;

    @Column(name = "PROPERTY_NAME")
    private String propertyName;

    @Column(name = "VALUE_ID")
    private String valueId;

    @Column(name = "VALUE_VALUE")
    private String valueValue;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPackageCapacity() {
        return packageCapacity;
    }

    public void setPackageCapacity(BigDecimal packageCapacity) {
        this.packageCapacity = packageCapacity;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getValueValue() {
        return valueValue;
    }

    public void setValueValue(String valueValue) {
        this.valueValue = valueValue;
    }
}
