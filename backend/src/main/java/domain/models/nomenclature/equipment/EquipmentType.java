package domain.models.nomenclature.equipment;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "EQUIPMENT_TYPES")
public class EquipmentType extends TypoTable {

    @Column(name = "TYPE")
    private String type;

    public EquipmentType() {}

    public EquipmentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
