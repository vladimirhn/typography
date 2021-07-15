package rest.nomenclature;

import kcollections.KList;

import java.util.Map;

public class JsonConsumableType {

    Long id;

    String type;

    Map<Long, String> properties;

    KList<JsonConsumableItem> data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public KList<JsonConsumableItem> getData() {
        return data;
    }

    public void setData(KList<JsonConsumableItem> data) {
        this.data = data;
    }
}
