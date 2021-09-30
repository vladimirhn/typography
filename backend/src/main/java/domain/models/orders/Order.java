package domain.models.orders;

import com.fasterxml.jackson.annotation.JsonFormat;
import rest.data.EntryTransferData;
import repository.tables.StringIdTable;
import kpersistence.mapping.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ORDERS")
public class Order extends StringIdTable {


    @Column(name = "ORDER_SUBJECTS_ID")
    String orderSubjectsId;

    @Foreign(table = OrderSubject.class, foreignId = "orderSubjectsId")
    private String orderSubjectName;

    @Column(name = "AMOUNT")
    Integer amount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @OrderBy(direction = Direction.DESC)
    @Column(name = "ORDERS_DATE")
    LocalDate orderDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "ORDERS_DEADLINE")
    LocalDate orderDeadline;

    @Column(name = "STATUS")
    String status;

    @Column(name = "CONFIRMED", rus = "согласовано")
    Boolean confirmed;

    @Column(name = "SUPPLIED", rus = "отгружено")
    Boolean supplied;

    List<EntryTransferData> relatedConsumables;

    public Order() {}

    public Order(String id, String orderSubjectsId, String orderSubjectName, Integer amount, LocalDate orderDate, LocalDate orderDeadline, String status, Boolean confirmed, Boolean supplied) {
        setId(id);
        this.orderSubjectsId = orderSubjectsId;
        this.orderSubjectName = orderSubjectName;
        this.amount = amount;
        this.orderDate = orderDate;
        this.orderDeadline = orderDeadline;
        this.status = status;
        this.confirmed = confirmed;
        this.supplied = supplied;
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

    public List<EntryTransferData> getRelatedConsumables() {
        return relatedConsumables;
    }

    public void setRelatedConsumables(List<EntryTransferData> relatedConsumables) {
        this.relatedConsumables = relatedConsumables;
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
