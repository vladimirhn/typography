package domain.models.nomenclature.equipment;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "EQUIPMENT_ITEMS")
public class EquipmentItem extends TypoTable {

    @Column(name = "TYPE_ID")
    private Long typeId;

    @Column(name = "ITEM")
    private String item;

    @Column(name = "MODEL")
    private String model;

    public EquipmentItem() {}

    public EquipmentItem(Long typeId, String item, String model) {
        this.typeId = typeId;
        this.item = item;
        this.model = model;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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
