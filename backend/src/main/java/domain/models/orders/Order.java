package domain.models.orders;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ORDERS")
public class Order extends TypoTable {

    public enum Status {
        UNDEFINED,
        CREATED,
        IN_PROCESS,
        COMPLETED
    }

    @Column(name = "ORDER_SUBJECTS_ID")
    String orderSubjectsId;

    @Foreign(table = OrderSubject.class, foreignId = "orderSubjectsId")
    private String orderSubjectName;

    @Column(name = "AMOUNT")
    Integer amount;

    @Column(name = "SIZE_X")
    BigDecimal sizeX;

    @Column(name = "SIZE_Y")
    BigDecimal sizeY;

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
    Enum<Status> status = Status.UNDEFINED;

    public Order() {}

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

    public BigDecimal getSizeX() {
        return sizeX;
    }

    public void setSizeX(BigDecimal sizeX) {
        this.sizeX = sizeX;
    }

    public BigDecimal getSizeY() {
        return sizeY;
    }

    public void setSizeY(BigDecimal sizeY) {
        this.sizeY = sizeY;
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

    public Enum<Status> getStatus() {
        return status;
    }

    public void setStatus(Enum<Status> status) {
        this.status = status;
    }
}
