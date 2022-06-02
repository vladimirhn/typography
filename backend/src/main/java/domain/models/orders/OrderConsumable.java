package domain.models.orders;

import domain.models.abstracts.TypographyTable;
import domain.models.nomenclature.consumables.ConsumableItem;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v1.mapping.annotations.Foreign;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "ORDERS_CONSUMABLES")
public class OrderConsumable extends TypographyTable {

    @Column(name = "ORDER_ID")
    String orderId;

    @Column(name = "CONSUMABLE_ITEM_ID")
    String consumableItemId;

    @Foreign(table = ConsumableItem.class, foreignId = "consumableItemId")
    private String consumableItemName;

    @Column(name = "QUANTITY")
    BigDecimal qty;

    public OrderConsumable() {}

    public OrderConsumable(String orderId, String consumableItemId, BigDecimal qty) {
        this.orderId = orderId;
        this.consumableItemId = consumableItemId;
        this.qty = qty;
    }

    public OrderConsumable(String id, String orderId, String consumableItemId, String consumableItemName, BigDecimal qty) {
        this(orderId, consumableItemId, qty);
        this.consumableItemName = consumableItemName;
        setId(id);
    }

    @Override
    public void setDefaults() {}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getConsumableItemId() {
        return consumableItemId;
    }

    public void setConsumableItemId(String consumableItemId) {
        this.consumableItemId = consumableItemId;
    }

    public String getConsumableItemName() {
        return consumableItemName;
    }

    public void setConsumableItemName(String consumableItemName) {
        this.consumableItemName = consumableItemName;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    //Util methods
    public void denullifyQty() {
        if (qty == null) qty = BigDecimal.ZERO;
    }
}
