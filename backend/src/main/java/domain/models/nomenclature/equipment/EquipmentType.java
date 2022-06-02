package domain.models.nomenclature.equipment;

import domain.models.abstracts.TypographyTable;
import kcollections.KList;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

@Entity
@Table(name = "EQUIPMENT_TYPES")
public class EquipmentType extends TypographyTable {

    @Column(name = "TYPE")
    private String type;

    private KList<EquipmentItem> equipmentItems;
    private KList<ComponentItem> componentItems;

    public EquipmentType() {}

    @Override
    public void setDefaults() {}

    public EquipmentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public KList<EquipmentItem> getEquipmentItems() {
        return equipmentItems;
    }

    public void setEquipmentItems(KList<EquipmentItem> equipmentItems) {
        this.equipmentItems = equipmentItems;
    }

    public KList<ComponentItem> getComponentItems() {
        return componentItems;
    }

    public void setComponentItems(KList<ComponentItem> componentItems) {
        this.componentItems = componentItems;
    }
}
