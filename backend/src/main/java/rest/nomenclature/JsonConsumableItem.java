package rest.nomenclature;

import java.util.Map;

public class JsonConsumableItem {

    String item;

    Map<Long, Map<Long, String>> values;

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
