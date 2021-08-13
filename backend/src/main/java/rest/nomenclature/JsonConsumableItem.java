package rest.nomenclature;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Map;

public class JsonConsumableItem {

    String itemId;

    String item;

    Map<String, Map<String, String>> values;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Map<String, Map<String, String>> getValues() {
        return values;
    }

    public void setValues(Map<String, Map<String, String>> values) {
        this.values = values;
    }
}
