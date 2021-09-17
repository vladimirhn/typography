package domain.models.nomenclature.equipment;

import kpersistence.repository.tables.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

@Entity
@Table(name = "EQUIPMENT_ITEMS")
public class EquipmentItem extends TypoTable {

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
