package rest.nomenclature;

import java.util.Map;

public class JsonConsumableItem {

    Long id;

    String item;

    Map<Long, Map<Long, String>> values;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Map<Long, Map<Long, String>> getValues() {
        return values;
    }

    public void setValues(Map<Long, Map<Long, String>> values) {
        this.values = values;
    }
}
