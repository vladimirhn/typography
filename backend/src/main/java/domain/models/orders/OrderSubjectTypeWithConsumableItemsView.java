package domain.models.orders;

import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;
import repository.tables.AbstractView;
import rest.nomenclature.JsonConsumableItem;

@Entity
@Table(name = "ORDER_SUBJECT_TYPE_WITH_CONSUMABLE_ITEMS_VIEW")
public class OrderSubjectTypeWithConsumableItemsView extends AbstractView {

    @Column(name = "ORDER_SUBJECT_TYPES_ID")
    private String orderSubjectTypeId;

    @Column(name = "ORDER_SUBJECT_TYPES_NAME")
    private String orderSubjectTypeName;

    @Column(name = "CONSUMABLE_ITEMS_ID")
    private String consumableItemId;

    @Column(name = "CONSUMABLE_ITEMS_ITEM")
    private String consumableItemItem;

    public OrderSubjectType getOrderSubjectType() {
        return new OrderSubjectType(orderSubjectTypeId, orderSubjectTypeName);
    }

    public JsonConsumableItem getJsonConsumableItem() {
        return new JsonConsumableItem(consumableItemId, consumableItemItem);
    }

    public String getOrderSubjectTypeId() {
        return orderSubjectTypeId;
    }

    public void setOrderSubjectTypeId(String orderSubjectTypeId) {
        this.orderSubjectTypeId = orderSubjectTypeId;
    }

    public String getOrderSubjectTypeName() {
        return orderSubjectTypeName;
    }

    public void setOrderSubjectTypeName(String orderSubjectTypeName) {
        this.orderSubjectTypeName = orderSubjectTypeName;
    }

    public String getConsumableItemId() {
        return consumableItemId;
    }

    public void setConsumableItemId(String consumableItemId) {
        this.consumableItemId = consumableItemId;
    }

    public String getConsumableItemItem() {
        return consumableItemItem;
    }

    public void setConsumableItemItem(String consumableItemItem) {
        this.consumableItemItem = consumableItemItem;
    }


}
