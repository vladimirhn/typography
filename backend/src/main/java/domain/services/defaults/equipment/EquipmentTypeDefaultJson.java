package domain.services.defaults.equipment;

import java.util.List;

public class EquipmentTypeDefaultJson {

    String type;
    List<ItemDefaultJson> items;
    List<ItemDefaultJson> components;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ItemDefaultJson> getItems() {
        return items;
    }

    public void setItems(List<ItemDefaultJson> items) {
        this.items = items;
    }

    public List<ItemDefaultJson> getComponents() {
        return components;
    }

    public void setComponents(List<ItemDefaultJson> components) {
        this.components = components;
    }
}
