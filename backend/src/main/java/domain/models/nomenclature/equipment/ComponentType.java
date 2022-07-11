package domain.models.nomenclature.equipment;

import rest.v2.models.JsonNonNullUserIdStringIdTable;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

@Entity
@Table(name = "COMPONENT_TYPES")
public class ComponentType extends JsonNonNullUserIdStringIdTable {

    @Column(name = "TYPE")
    private String type;

    @Override
    public void setDefaults() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
