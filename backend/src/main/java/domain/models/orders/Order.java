package domain.models.orders;

import rest.v2.models.JsonNonNullUserIdStringIdTable;
import domain.models.counterparties.LegalEntity;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Foreign2;
import kpersistence.v2.annotations.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Table(name = "ORDERS")
public class Order extends JsonNonNullUserIdStringIdTable {

    @Column(name = "ORDER_SUBJECTS_ID", foreign = OrderSubject.class, nonNull = true)
    String orderSubjectId;

    @Foreign2
    private OrderSubject orderSubject;

    @Column(name = "LEGAL_ENTITY_ID", foreign = LegalEntity.class)
    private String legalEntityId;

    @Foreign2
    private LegalEntity legalEntity;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "ORDERS_DATE")
    private LocalDate orderDate;

    @Column(name = "ORDERS_DEADLINE")
    private LocalDate orderDeadline;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CONFIRMED")
    private Boolean confirmed;

    @Column(name = "SUPPLIED")
    private Boolean supplied;

    @Column(name = "MONEY_RECEIVED")
    private BigDecimal moneyReceived;

    @Column(name = "COMMENT")
    private String comment;

    private List<OrderConsumable> relatedConsumables;

    public Order() {}

    @Override
    public void setDefaults() {}

    public String getOrderSubjectId() {
        return orderSubjectId;
    }

    public void setOrderSubjectId(String orderSubjectId) {
        this.orderSubjectId = orderSubjectId;
    }

    public OrderSubject getOrderSubject() {
        return orderSubject;
    }

    public void setOrderSubject(OrderSubject orderSubject) {
        this.orderSubject = orderSubject;
    }

    public String getLegalEntityId() {
        return legalEntityId;
    }

    public void setLegalEntityId(String legalEntityId) {
        this.legalEntityId = legalEntityId;
    }

    public LegalEntity getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntity legalEntity) {
        this.legalEntity = legalEntity;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
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

    public BigDecimal getMoneyReceived() {
        return moneyReceived;
    }

    public void setMoneyReceived(BigDecimal moneyReceived) {
        this.moneyReceived = moneyReceived;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<OrderConsumable> getRelatedConsumables() {
        return relatedConsumables;
    }

    public void setRelatedConsumables(List<OrderConsumable> relatedConsumables) {
        this.relatedConsumables = relatedConsumables;
    }
}
