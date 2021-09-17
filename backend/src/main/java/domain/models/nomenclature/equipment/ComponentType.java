package domain.models.nomenclature.equipment;

import repository.tables.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "COMPONENT_TYPES")
public class ComponentType extends TypoTable {

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
