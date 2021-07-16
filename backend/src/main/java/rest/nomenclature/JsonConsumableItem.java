package rest.nomenclature;

import java.util.Map;

public class JsonConsumableItem {

    Long itemId;

    String item;

    Map<Long, Map<Long, String>> values;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
