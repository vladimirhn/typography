package domain.models.orders;

import kpersistence.repository.tables.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "ORDER_SUBJECT_TYPES_CONSUMABLES")
public class OrderSubjectTypesConsumables extends TypoTable {

    @Column(name = "ORDER_SUBJECT_TYPE_ID")
    String orderSubjectTypeId;

    @Column(name = "CONSUMABLE_ITEM_ID")
    String consumableItemId;

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

}
