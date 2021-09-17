package domain.models.nomenclature.consumables;

import repository.tables.StringIdTable;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CONSUMABLE_TYPES")
public class ConsumableType extends StringIdTable {

    @Column(name = "TYPE")
    private String type;

    private List<ConsumableProperty> properties = new ArrayList<>();

    private List<ConsumableItem> consumableItems = new ArrayList<>();

    public ConsumableType() {}

    @Override
    public void setDefaults() {}

    public ConsumableType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ConsumableProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<ConsumableProperty> properties) {
        this.properties = properties;
    }

    public List<ConsumableItem> getConsumableItems() {
        return consumableItems;
    }

    public void setConsumableItems(List<ConsumableItem> consumableItems) {
        this.consumableItems = consumableItems;
    }
}
