package domain.models.orders;

import kpersistence.annotations.Column;
import kpersistence.annotations.Label;
import kpersistence.annotations.Table;
import rest.v2.models.JsonNonNullUserIdStringIdTable;

import java.util.Objects;

@Table(name = "ORDER_SUBJECT_TYPES")
public class OrderSubjectType extends JsonNonNullUserIdStringIdTable {

    @Label
    @Column(name = "NAME")
    String name;

    public OrderSubjectType() {}

    public OrderSubjectType(String name) {
        this.name = name;
    }

    public OrderSubjectType(String id, String name) {
        this(name);
        this.setId(id);
    }

    @Override
    public void setDefaults() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderSubjectType)) return false;
        OrderSubjectType that = (OrderSubjectType) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
