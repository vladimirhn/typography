package domain.models.orders;

import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Label;
import kpersistence.mapping.annotations.Table;
import repository.tables.UserIdStringIdTable;

import java.util.Objects;

@Entity
@Table(name = "ORDER_SUBJECT_TYPES")
public class OrderSubjectType extends UserIdStringIdTable {

    @Column(name = "NAME", rus = "вид заказа")
    @Label
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
