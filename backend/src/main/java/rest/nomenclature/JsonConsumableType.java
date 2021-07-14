package rest.nomenclature;

import java.util.Map;

public class JsonConsumableType {

    String type;

    Map<Long, String> properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<Long, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<Long, String> properties) {
        this.properties = properties;
    }
}
