package domain.models.nomenclature.equipment;

import domain.models.abstracts.TypoTable;
import kcollections.KList;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "EQUIPMENT_TYPES")
public class EquipmentType extends TypoTable {

    @Column(name = "TYPE")
    private String type;

    private KList<EquipmentItem> equipmentItems;
    private KList<ComponentItem> componentItems;

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