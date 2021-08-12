package domain.models.nomenclature.equipment;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "COMPONENT_ITEMS")
public class ComponentItem extends TypoTable {

    @Column(name = "TYPE_ID")
    private Long typeId;

    @Column(name = "EQUIPMENT_TYPE_ID")
    private Long equipmentTypeId;

    @Column(name = "ITEM")
    private String item;

    @Column(name = "MODEL")
    private String model;

    public ComponentItem() {}

    @Override
    public void setDefaults() {}

    public ComponentItem(Long equipmentTypeId, String item, String model) {
        this.equipmentTypeId = equipmentTypeId;
        this.item = item;
        this.model = model;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(Long equipmentTypeId) {
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
