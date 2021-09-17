package domain.models.orders;

import kpersistence.repository.tables.TypoTable;
import kpersistence.mapping.annotations.*;

@Entity
@Table(name = "ORDER_SUBJECTS")
public class OrderSubject extends TypoTable {

    @Column(name = "NAME", rus = "продукция")
    @Label
    @OrderBy(direction = Direction.ASC)
    String name;

    @Column(name = "ORDER_SUBJECT_TYPE_ID")
    String orderSubjectTypeId;

    @Foreign(table = OrderSubjectType.class, foreignId = "orderSubjectTypeId")
    String orderSubjectTypeName;

    public OrderSubject() {}

    public OrderSubject(String name) {
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

    public String getOrderSubjectTypeId() {
        return orderSubjectTypeId;
    }

    public void setOrderSubjectTypeId(String orderSubjectTypeId) {
        this.orderSubjectTypeId = orderSubjectTypeId;
    }

    public String getOrderSubjectTypeName() {
        return orderSubjectTypeName;
    }

    public void setOrderSubjectTypeName(String orderSubjectTypeName) {
        this.orderSubjectTypeName = orderSubjectTypeName;
    }
}
