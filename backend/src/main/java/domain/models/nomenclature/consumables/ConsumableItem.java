package domain.models.nomenclature.consumables;

import domain.models.abstracts.TypoTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CONSUMABLE_ITEMS")
public class ConsumableItem extends TypoTable {

    @Column(name = "TYPE_ID")
    private Long typeId;

    @Column(name = "ITEM")
    private String item;

    private List<ConsumablePropertyValue> propValues = new ArrayList<>();

    public ConsumableItem() {}

    public ConsumableItem(String item) {
        this.item = item;
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

    public List<ConsumablePropertyValue> getPropValues() {
        return propValues;
    }

    public void setPropValues(List<ConsumablePropertyValue> propValues) {
        this.propValues = propValues;
    }
}
