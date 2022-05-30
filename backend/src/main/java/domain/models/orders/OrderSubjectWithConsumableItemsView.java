package domain.models.orders;

import repository.v1.tables.UserIdAbstractView;
import rest.v1.data.EntryTransferData;
import kpersistence.v2.annotations.Column;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v2.annotations.Table;

@Entity
@Table(name = "ORDER_SUBJECT_WITH_CONSUMABLE_ITEMS_VIEW")
public class OrderSubjectWithConsumableItemsView extends UserIdAbstractView {

    @Column(name = "ORDER_SUBJECT_TYPE_ID")
    String orderSubjectTypeId;

    @Column(name = "ORDER_SUBJECT_TYPE_NAME")
    String orderSubjectTypeName;

    @Column(name = "ORDER_SUBJECT_ID")
    private String orderSubjectId;

    @Column(name = "ORDER_SUBJECT_NAME")
    private String orderSubjectName;

    @Column(name = "CONSUMABLE_ITEMS_ID")
    private String consumableItemId;

    @Column(name = "CONSUMABLE_ITEMS_ITEM")
    private String consumableItemItem;

    public OrderSubjectType extractOrderSubjectType() {
        return new OrderSubjectType(orderSubjectTypeId, orderSubjectTypeName);
    }

    public OrderSubject extractOrderSubject() {
        return new OrderSubject(orderSubjectId, orderSubjectName, orderSubjectTypeId, orderSubjectTypeName);
    }

    public EntryTransferData extractMinimalConsumableItemData() {
        return new EntryTransferData(consumableItemId, consumableItemItem);
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

    public String getOrderSubjectId() {
        return orderSubjectId;
    }

    public void setOrderSubjectId(String orderSubjectId) {
        this.orderSubjectId = orderSubjectId;
    }

    public String getOrderSubjectName() {
        return orderSubjectName;
    }

    public void setOrderSubjectName(String orderSubjectName) {
        this.orderSubjectName = orderSubjectName;
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
