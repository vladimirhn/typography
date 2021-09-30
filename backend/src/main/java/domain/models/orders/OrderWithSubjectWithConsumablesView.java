package domain.models.orders;

import com.fasterxml.jackson.annotation.JsonFormat;
import rest.data.EntryTransferData;
import kpersistence.mapping.annotations.*;
import repository.tables.AbstractView;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ORDER_WITH_SUBJECT_WITH_CONSUMABLES_VIEW")
public class OrderWithSubjectWithConsumablesView extends AbstractView {

    @Column(name = "ORDER_ID")
    String orderId;

    @Column(name = "AMOUNT")
    Integer amount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @OrderBy(direction = Direction.DESC)
    @Column(name = "ORDER_DATE")
    LocalDate orderDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ORDER_DEADLINE")
    LocalDate orderDeadline;

    @Column(name = "STATUS")
    String status;

    @Column(name = "CONFIRMED", rus = "согласовано")
    Boolean confirmed;

    @Column(name = "SUPPLIED", rus = "отгружено")
    Boolean supplied;

    @Column(name = "ORDER_SUBJECT_ID")
    private String orderSubjectId;

    @Column(name = "ORDER_SUBJECT_NAME")
    private String orderSubjectName;

    @Column(name = "CONSUMABLE_ITEM_ID")
    private String consumableItemId;

    @Column(name = "CONSUMABLE_ITEM_ITEM")
    private String consumableItemItem;

    @Column(name = "QUANTITY")
    private BigDecimal qty;

    public Order extractOrder() {
        return new Order(orderId, orderSubjectId, orderSubjectName, amount, orderDate, orderDeadline, status, confirmed, supplied);
    }

    public EntryTransferData extractMinimalConsumableItemData() {
        return new EntryTransferData(consumableItemId, consumableItemItem, qty);
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getOrderDeadline() {
        return orderDeadline;
    }

    public void setOrderDeadline(LocalDate orderDeadline) {
        this.orderDeadline = orderDeadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Boolean getSupplied() {
        return supplied;
    }

    public void setSupplied(Boolean supplied) {
        this.supplied = supplied;
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

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
}
