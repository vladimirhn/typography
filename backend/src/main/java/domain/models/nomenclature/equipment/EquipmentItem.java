package domain.models.nomenclature.equipment;

import domain.models.abstracts.TypographyTable;
import kpersistence.v1.mapping.annotations.Entity;
import kpersistence.v2.annotations.Column;
import kpersistence.v2.annotations.Table;

@Entity
@Table(name = "EQUIPMENT_ITEMS")
public class EquipmentItem extends TypographyTable {

    @Column(name = "TYPE_ID")
    private String typeId;

    @Column(name = "ITEM")
    private String item;

    @Column(name = "MODEL")
    private String model;

    public EquipmentItem() {}

    @Override
    public void setDefaults() {}

    public EquipmentItem(String typeId, String item, String model) {
        this.typeId = typeId;
        this.item = item;
        this.model = model;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
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
