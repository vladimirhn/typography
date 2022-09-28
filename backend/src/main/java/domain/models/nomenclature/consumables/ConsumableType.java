package domain.models.nomenclature.consumables;

import rest.models.JsonNonNullUserIdStringIdTable;
import kpersistence.annotations.Label;
import kpersistence.types.SoftDelete;
import kpersistence.annotations.Column;
import kpersistence.annotations.Table;

import java.util.ArrayList;
import java.util.List;

@Table(name = "CONSUMABLE_TYPES")
public class ConsumableType extends JsonNonNullUserIdStringIdTable implements SoftDelete {

    @Column(name = "TYPE")
    @Label
    private String type;

    @Column(name = "DELETED")
    private Boolean deleted;

    private List<ConsumableProperty> properties = new ArrayList<>();

    private List<ConsumableItem> items = new ArrayList<>();

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

    @Override
    public Boolean getDeleted() {
        return deleted;
    }

    @Override
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public List<ConsumableProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<ConsumableProperty> properties) {
        this.properties = properties;
    }

    public List<ConsumableItem> getItems() {
        return items;
    }

    public void setItems(List<ConsumableItem> items) {
        this.items = items;
    }
}
