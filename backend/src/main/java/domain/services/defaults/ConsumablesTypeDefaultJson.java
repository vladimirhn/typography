package domain.services.defaults;

import java.util.List;

public class ConsumablesTypeDefaultJson {

    String type;
    List<String> properties;
    List<ConsumablesItemDefaultJson> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    public List<ConsumablesItemDefaultJson> getData() {
        return data;
    }

    public void setData(List<ConsumablesItemDefaultJson> data) {
        this.data = data;
    }
}
