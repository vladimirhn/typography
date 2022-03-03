package domain.models.orders;

import com.fasterxml.jackson.annotation.JsonFormat;
import domain.models.counterparties.LegalEntity;
import kcollections.CollectionFactory;
import kcollections.KList;
import kpersistence.mapping.annotations.*;
import repository.tables.StringIdTable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ORDERS")
public class Order extends StringIdTable {


    @Column(name = "ORDER_SUBJECTS_ID")
    String orderSubjectsId;

//Используем вьюху
//    @Foreign(table = OrderSubject.class, foreignId = "orderSubjectsId")
    private String orderSubjectName;

    @Column(name = "LEGAL_ENTITY_ID")
    private String legalEntityId;

//Используем вьюху
//    @Foreign(table = LegalEntity.class, foreignId = "legalEntityId")
    private String legalEntityName;

    @Column(name = "AMOUNT")
    private Long amount;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @OrderBy(direction = Direction.DESC)
    @Column(name = "ORDERS_DATE")
    private LocalDate orderDate;

    @JsonFormat(pattern = "dd.MM.yyyy")
    @Column(name = "ORDERS_DEADLINE")
    private LocalDate orderDeadline;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CONFIRMED", rus = "согласовано")
    private Boolean confirmed;

    @Column(name = "SUPPLIED", rus = "отгружено")
    private Boolean supplied;

    @Column(name = "MONEY_RECEIVED")
    private BigDecimal moneyReceived;

    @Column(name = "COMMENT")
    private String comment;

    private List<OrderConsumable> relatedConsumables;

    public Order() {}

    public Order(String orderId, String orderSubjectsId, String orderSubjectName, String legalEntityId,
                 String legalEntityName, Long amount, String comment, LocalDate orderDate, LocalDate orderDeadline,
                 String status, Boolean confirmed, Boolean supplied, BigDecimal moneyReceived) {
        this.setId(orderId);
        this.orderSubjectsId = orderSubjectsId;
        this.orderSubjectName = orderSubjectName;
        this.legalEntityId = legalEntityId;
        this.legalEntityName = legalEntityName;
        this.amount = amount;
        this.comment = comment;
        this.orderDate = orderDate;
        this.orderDeadline = orderDeadline;
        this.status = status;
        this.confirmed = confirmed;
        this.supplied = supplied;
        this.moneyReceived = moneyReceived;
    }

    @Override
    public void setDefaults() {}

    public String getOrderSubjectsId() {
        return orderSubjectsId;
    }

    public void setOrderSubjectsId(String orderSubjectsId) {
        this.orderSubjectsId = orderSubjectsId;
    }

    public String getOrderSubjectName() {
        return orderSubjectName;
    }

    public void setOrderSubjectName(String orderSubjectName) {
        this.orderSubjectName = orderSubjectName;
    }

    public String getLegalEntityId() {
        return legalEntityId;
    }

    public void setLegalEntityId(String legalEntityId) {
        this.legalEntityId = legalEntityId;
    }

    public String getLegalEntityName() {
        return legalEntityName;
    }

    public void setLegalEntityName(String legalEntityName) {
        this.legalEntityName = legalEntityName;
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

    public KList<OrderConsumable> getRelatedConsumables() {
        return CollectionFactory.makeList(relatedConsumables);
    }

    public void setRelatedConsumables(List<OrderConsumable> relatedConsumables) {
        this.relatedConsumables = relatedConsumables;
    }

    public BigDecimal getMoneyReceived() {
        return moneyReceived != null ? moneyReceived : BigDecimal.ZERO;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return getId().equals(order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
