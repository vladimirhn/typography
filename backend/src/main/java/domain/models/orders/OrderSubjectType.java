package domain.models.orders;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Label;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "ORDER_SUBJECT_TYPES")
public class OrderSubjectType extends TypoTable {

    @Column(name = "NAME", rus = "вид заказа")
    @Label
    String name;

    public OrderSubjectType() {}

    public OrderSubjectType(String name) {
        this.name = name;
    }

    @Override
    public void setDefaults() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
