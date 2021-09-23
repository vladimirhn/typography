package domain.models.orders;

import repository.tables.StringIdTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "ORDER_SUBJECT_TYPES_CONSUMABLES")
public class OrderSubjectTypesConsumables extends StringIdTable {

    @Column(name = "ORDER_SUBJECT_TYPE_ID")
    String orderSubjectTypeId;

    @Column(name = "CONSUMABLE_ITEM_ID")
    String consumableItemId;

    @Column(name = "IS_PARENT")
    Boolean isParent;

    public OrderSubjectTypesConsumables() {}

    public OrderSubjectTypesConsumables(String orderSubjectTypeId, String consumableItemId) {
        this.orderSubjectTypeId = orderSubjectTypeId;
        this.consumableItemId = consumableItemId;
    }

    @Override
    public void setDefaults() {}

    public String getOrderSubjectTypeId() {
        return orderSubjectTypeId;
    }

    public void setOrderSubjectTypeId(String orderSubjectTypeId) {
        this.orderSubjectTypeId = orderSubjectTypeId;
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
