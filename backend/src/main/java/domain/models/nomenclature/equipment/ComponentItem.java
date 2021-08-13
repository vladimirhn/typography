package domain.models.nomenclature.equipment;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "COMPONENT_ITEMS")
public class ComponentItem extends TypoTable {

    @Column(name = "TYPE_ID")
    private String typeId;

    @Column(name = "EQUIPMENT_TYPE_ID")
    private String equipmentTypeId;

    @Column(name = "ITEM")
    private String item;

    @Column(name = "MODEL")
    private String model;

    public ComponentItem() {}

    @Override
    public void setDefaults() {}

    public ComponentItem(String equipmentTypeId, String item, String model) {
        this.equipmentTypeId = equipmentTypeId;
        this.item = item;
        this.model = model;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(String equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
