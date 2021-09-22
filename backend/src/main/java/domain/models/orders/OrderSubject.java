package domain.models.orders;

import repository.tables.StringIdTable;
import kpersistence.mapping.annotations.*;
import rest.nomenclature.JsonConsumableItem;
import rest.response.JsonTableResponse;

import java.util.List;

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
    List<JsonConsumableItem> relatedParentJsonConsumableItems;
    @JsonTableResponse(addToProperties = false)
    List<JsonConsumableItem> relatedOwnJsonConsumableItems;

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

    public List<JsonConsumableItem> getRelatedParentJsonConsumableItems() {
        return relatedParentJsonConsumableItems;
    }

    public void setRelatedParentJsonConsumableItems(List<JsonConsumableItem> relatedParentJsonConsumableItems) {
        this.relatedParentJsonConsumableItems = relatedParentJsonConsumableItems;
    }

    public List<JsonConsumableItem> getRelatedOwnJsonConsumableItems() {
        return relatedOwnJsonConsumableItems;
    }

    public void setRelatedOwnJsonConsumableItems(List<JsonConsumableItem> relatedOwnJsonConsumableItems) {
        this.relatedOwnJsonConsumableItems = relatedOwnJsonConsumableItems;
    }
}
