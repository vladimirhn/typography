package rest.nomenclature;

import kcollections.KList;

import java.util.Map;

public class JsonConsumableType {

    String type;

    Map<Long, String> properties;

    Map<Long, KList<JsonConsumableItem>> data;

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

    public Map<Long, KList<JsonConsumableItem>> getData() {
        return data;
    }

    public void setData(Map<Long, KList<JsonConsumableItem>> data) {
        this.data = data;
    }
}
