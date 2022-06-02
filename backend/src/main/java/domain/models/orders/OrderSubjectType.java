package domain.models.orders;

import domain.models.abstracts.TypographyTable;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v1.mapping.annotations.Label;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

import java.util.Objects;

@Entity
@Table(name = "ORDER_SUBJECT_TYPES")
public class OrderSubjectType extends TypographyTable {

    @Column(name = "NAME")
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
