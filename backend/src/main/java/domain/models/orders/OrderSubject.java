package domain.models.orders;

import rest.data.EntryTransferData;
import repository.tables.StringIdTable;
import kpersistence.mapping.annotations.*;
import rest.response.JsonTableResponse;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ORDER_SUBJECTS")
public class OrderSubject extends StringIdTable {

    @Column(name = "NAME", rus = "продукция")
    @Label
    @OrderBy(direction = Direction.ASC)
    String name;

    @Column(name = "ORDER_SUBJECT_TYPE_ID")
    String orderSubjectTypeId;

    @Foreign(table = OrderSubjectType.class, foreignId = "orderSubjectTypeId")
    String orderSubjectTypeName;

    @JsonTableResponse(addToProperties = false)
    List<EntryTransferData> relatedParentConsumableItems;
    @JsonTableResponse(addToProperties = false)
    List<EntryTransferData> relatedOwnConsumableItems;

    public OrderSubject() {}

    public OrderSubject(String name) {
        this.name = name;
    }

    public OrderSubject(String id, String name) {
        this(name);
        setId(id);
    }

    public OrderSubject(String id, String name, String orderSubjectTypeId, String orderSubjectTypeName) {
        this(id, name);
        this.orderSubjectTypeId = orderSubjectTypeId;
        this.orderSubjectTypeName = orderSubjectTypeName;
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

    public List<EntryTransferData> getRelatedParentConsumableItems() {
        return relatedParentConsumableItems;
    }

    public void setRelatedParentConsumableItems(List<EntryTransferData> relatedParentConsumableItems) {
        this.relatedParentConsumableItems = relatedParentConsumableItems;
    }

    public List<EntryTransferData> getRelatedOwnConsumableItems() {
        return relatedOwnConsumableItems;
    }

    public void setRelatedOwnConsumableItems(List<EntryTransferData> relatedOwnConsumableItems) {
        this.relatedOwnConsumableItems = relatedOwnConsumableItems;
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
