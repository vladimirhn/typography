package domain.models.orders;

import domain.models.nomenclature.consumables.ConsumableItem;
import kpersistence.annotations.Column;
import kpersistence.annotations.Foreign;
import kpersistence.annotations.Table;
import rest.models.JsonNonNullUserIdStringIdTable;

import java.math.BigDecimal;

@Table(name = "ORDERS_CONSUMABLES")
public class OrderConsumable extends JsonNonNullUserIdStringIdTable {

    @Column(name = "ORDER_ID")
    String orderId;

    @Column(name = "CONSUMABLE_ITEM_ID", foreign = ConsumableItem.class)
    String consumableItemId;

    @Foreign
    ConsumableItem consumableItem;

    @Column(name = "QUANTITY")
    BigDecimal qty;

    public OrderConsumable() {}

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

    public ConsumableItem getConsumableItem() {
        return consumableItem;
    }

    public void setConsumableItem(ConsumableItem consumableItem) {
        this.consumableItem = consumableItem;
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
