package domain.models.orders;

import kpersistence.annotations.Column;
import kpersistence.annotations.Table;
import rest.models.JsonNonNullUserIdStringIdTable;

@Table(name = "ORDER_SUBJECT_PARAMETERS")
public class OrderSubjectParameters extends JsonNonNullUserIdStringIdTable {

    @Column(name = "ORDER_SUBJECT_ID")
    String orderSubjectId;

    @Column(name = "PARAMETER_ID")
    String parameterId;

    @Column(name = "IS_PARENT")
    Boolean isParent;

    public OrderSubjectParameters() {}

    public OrderSubjectParameters(String orderSubjectId, String parameterId) {
        this.orderSubjectId = orderSubjectId;
        this.parameterId = parameterId;
    }

    @Override
    public void setDefaults() {}

    public String getOrderSubjectId() {
        return orderSubjectId;
    }

    public void setOrderSubjectId(String orderSubjectId) {
        this.orderSubjectId = orderSubjectId;
    }

    public String getParameterId() {
        return parameterId;
    }

    public void setParameterId(String parameterId) {
        this.parameterId = parameterId;
    }

    public Boolean isParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }
}
