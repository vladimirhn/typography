package domain.models.nomenclature.consumables;

import domain.models.abstracts.TypographyTable;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v2.annotations.Foreign2;
import kpersistence.v2.annotations.Label;
import kpersistence.v1.mapping.annotations.ParentId;
import kpersistence.v1.types.SoftDelete;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "CONSUMABLE_ITEMS")
public class ConsumableItem extends TypographyTable implements SoftDelete {

    @Column(name = "TYPE_ID", foreign = ConsumableType.class)
    @ParentId(table = ConsumableType.class) //to delete
    private String typeId;

    @Foreign2
    private ConsumableType type;

    @Column(name = "ITEM")
    @Label
    private String item;

    @Column(name = "PACKAGE_CAPACITY")
    private BigDecimal packageCapacity;

    @Column(name = "DELETED")
    private Boolean deleted;

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

    @Override
    public Boolean getDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
