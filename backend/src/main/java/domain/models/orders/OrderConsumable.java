package domain.models.orders;

import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;
import repository.tables.StringIdTable;

@Entity
@Table(name = "ORDERS_CONSUMABLES")
public class OrderConsumable extends StringIdTable {

    @Column(name = "ORDER_ID")
    String orderId;

    @Column(name = "CONSUMABLE_ITEM_ID")
    String consumableItemId;

    @Column(name = "QUANTITY")
    Double qty;

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

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }
}
