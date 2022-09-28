package domain.models.nomenclature.consumables;

import kcollections.KList;
import kpersistence.annotations.Column;
import kpersistence.annotations.Table;
import rest.models.JsonNonNullUserIdView;

import java.math.BigDecimal;
import java.util.Map;


@Table(name = "ALL_CONSUMABLES_VIEW")
public class ConsumablesView extends JsonNonNullUserIdView {

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

    private KList<ConsumablesView> items;
    private KList<ConsumablesView> properties;
    private Map<String, String> propertyIds;

    public ConsumablesView toType() {
        ConsumablesView typeView = new ConsumablesView();
        typeView.setTypeId(typeId);
        typeView.setTypeName(typeName);
        return typeView;
    }

    public ConsumablesView toItem() {
        ConsumablesView itemView = new ConsumablesView();
        itemView.setItemId(itemId);
        itemView.setItemName(itemName);
        itemView.setPackageCapacity(packageCapacity);
        return itemView;
    }

    public ConsumablesView toProperty() {
        ConsumablesView propView = new ConsumablesView();
        propView.setPropertyId(propertyId);
        propView.setPropertyName(propertyName);
        propView.setValueId(valueId);
        propView.setValueValue(valueValue);
        return propView;
    }

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

    public KList<ConsumablesView> getItems() {
        return items;
    }

    public void setItems(KList<ConsumablesView> items) {
        this.items = items;
    }

    public KList<ConsumablesView> getProperties() {
        return properties;
    }

    public void setProperties(KList<ConsumablesView> properties) {
        this.properties = properties;
    }

    public Map<String, String> getPropertyIds() {
        return propertyIds;
    }

    public void setPropertyIds(Map<String, String> propertyIds) {
        this.propertyIds = propertyIds;
    }
}
