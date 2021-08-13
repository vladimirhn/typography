package rest.nomenclature;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import kcollections.KList;

import java.util.HashMap;
import java.util.Map;

public class JsonConsumableType {

    String id;

    String type;

    Map<String, String> properties;

    KList<JsonConsumableItem> data;

    public JsonConsumableType() {
        properties = new HashMap<>();
        data = new KList<>();
    }

    public JsonConsumableType(String id, String type) {
        this();
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public KList<JsonConsumableItem> getData() {
        return data;
    }

    public void setData(KList<JsonConsumableItem> data) {
        this.data = data;
    }
}
