package domain.models.orders;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "ORDER_SUBJECT_TYPES_CONSUMABLES")
public class OrderSubjectTypesConsumables extends TypoTable {

    @Column(name = "ORDER_SUBJECT_TYPE_ID")
    String orderSubjectTypeId;

    @Column(name = "consumable_item_id")
    String consumableItemId;

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
