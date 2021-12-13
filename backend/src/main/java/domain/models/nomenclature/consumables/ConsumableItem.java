package domain.models.nomenclature.consumables;

import kpersistence.types.SoftDelete;
import repository.tables.StringIdTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Label;
import kpersistence.mapping.annotations.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CONSUMABLE_ITEMS")
public class ConsumableItem extends StringIdTable implements SoftDelete {

    @Column(name = "TYPE_ID")
    private String typeId;

    @Column(name = "ITEM")
    @Label
    private String item;

    @Column(name = "PACKAGE_CAPACITY")
    private BigDecimal packageCapacity;

    @Column(name = "DELETED")
    private Boolean deleted;

    private List<ConsumablePropertyValue> propValues = new ArrayList<>();

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

    @Override
    public Boolean getDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public List<ConsumablePropertyValue> getPropValues() {
        return propValues;
    }

    public void setPropValues(List<ConsumablePropertyValue> propValues) {
        this.propValues = propValues;
    }
}
