package domain.models.nomenclature.consumables;

import kcollections.CollectionFactory;
import kcollections.KList;
import kpersistence.annotations.Column;
import kpersistence.annotations.Foreign;
import kpersistence.annotations.Label;
import kpersistence.annotations.Table;
import kpersistence.types.SoftDelete;
import rest.models.JsonNonNullUserIdStringIdTable;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "CONSUMABLE_ITEMS")
public class ConsumableItem extends JsonNonNullUserIdStringIdTable implements SoftDelete {

    @Column(name = "TYPE_ID", foreign = ConsumableType.class)
    private String typeId;

    @Foreign
    private ConsumableType type;

    @Column(name = "ITEM")
    @Label
    private String item;

    @Column(name = "PACKAGE_CAPACITY")
    private BigDecimal packageCapacity;

    @Column(name = "DELETED")
    private Boolean deleted;

    private List<ConsumablePropertyValue> propertyValues;

    public ConsumableItem() {}

    @Override
    public void setDefaults() {}

    public ConsumableItem(String item) {
        this.item = item;
    }

    public ConsumableItem(String typeId, String item) {
        this.typeId = typeId;
        this.item = item;
    }

    public ConsumableItem(String newItemId, String typeId, String item) {
        setId(newItemId);
        this.typeId = typeId;
        this.item = item;
    }

    public ConsumableItem(String newItemId, String typeId, String item, BigDecimal packageCapacity) {
        this(newItemId, typeId, item);
        this.packageCapacity = packageCapacity;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public ConsumableType getType() {
        return type;
    }

    public void setType(ConsumableType type) {
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getPackageCapacity() {
        return packageCapacity;
    }

    public void setPackageCapacity(BigDecimal packageCapacity) {
        this.packageCapacity = packageCapacity;
    }

    public KList<ConsumablePropertyValue> getPropertyValues() {
        return CollectionFactory.makeList(propertyValues);
    }

    public void setPropertyValues(List<ConsumablePropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }

    @Override
    public Boolean getDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
