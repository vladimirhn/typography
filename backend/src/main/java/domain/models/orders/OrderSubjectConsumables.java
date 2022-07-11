package domain.models.orders;

import rest.v2.models.JsonNonNullUserIdStringIdTable;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

@Entity
@Table(name = "ORDER_SUBJECT_CONSUMABLES")
public class OrderSubjectConsumables extends JsonNonNullUserIdStringIdTable {

    @Column(name = "ORDER_SUBJECT_ID")
    String orderSubjectId;

    @Column(name = "CONSUMABLE_ITEM_ID")
    String consumableItemId;

    @Column(name = "IS_PARENT")
    Boolean isParent;

    public OrderSubjectConsumables() {}

    public OrderSubjectConsumables(String orderSubjectId, String consumableItemId) {
        this.orderSubjectId = orderSubjectId;
        this.consumableItemId = consumableItemId;
    }

    @Override
    public void setDefaults() {}

    public String getOrderSubjectId() {
        return orderSubjectId;
    }

    public void setOrderSubjectId(String orderSubjectId) {
        this.orderSubjectId = orderSubjectId;
    }

    public String getConsumableItemId() {
        return consumableItemId;
    }

    public void setConsumableItemId(String consumableItemId) {
        this.consumableItemId = consumableItemId;
    }

    public Boolean isParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }
}
