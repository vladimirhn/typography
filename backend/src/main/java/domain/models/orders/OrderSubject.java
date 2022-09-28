package domain.models.orders;

import kpersistence.annotations.*;
import rest.models.JsonNonNullUserIdStringIdTable;

import java.util.Objects;

@Table(name = "ORDER_SUBJECTS")
public class OrderSubject extends JsonNonNullUserIdStringIdTable {

    @Label
    @Column(name = "NAME")
    @OrderBy(direction = Direction.ASC)
    String name;

    @Column(name = "ORDER_SUBJECT_TYPE_ID", foreign = OrderSubjectType.class, nonNull = true)
    private String orderSubjectTypeId;

    @Foreign
    private OrderSubjectType orderSubjectType;

    public OrderSubject() {}

    public OrderSubject(String name) {
        this.name = name;
    }

    public OrderSubject(String id, String name) {
        this(name);
        setId(id);
    }

    @Override
    public void setDefaults() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderSubjectTypeId() {
        return orderSubjectTypeId;
    }

    public void setOrderSubjectTypeId(String orderSubjectTypeId) {
        this.orderSubjectTypeId = orderSubjectTypeId;
    }

    public OrderSubjectType getOrderSubjectType() {
        return orderSubjectType;
    }

    public void setOrderSubjectType(OrderSubjectType orderSubjectType) {
        this.orderSubjectType = orderSubjectType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderSubject that = (OrderSubject) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
