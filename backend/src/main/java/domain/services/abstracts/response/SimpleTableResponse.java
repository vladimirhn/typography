package domain.services.abstracts.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import kpersistence.mapping.annotations.Column;
import kutils.ClassUtils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimpleTableResponse extends KResponse {

    Collection<?> data;
    List<String> properties = new LinkedList<>();
    List<String> rus = new LinkedList<>();

    public SimpleTableResponse(Collection<?> data, Class<?> type, DictionaryDataProvider dict) {

        this.data = data;

        List<Field> fields = ClassUtils.getFieldsUpToObject(type);

        for (Field field : fields) {
            if (field.isAnnotationPresent(Column.class)) {
                Column columnData = field.getAnnotation(Column.class);
                String columnName = columnData.name();
                String rus = columnData.rus();
                if (rus.equals("")) {
                    rus = dict.russian(columnName);
                }
                String fieldName = field.getName();

                if (!columnData.isAncillary()) {
                    properties.add(fieldName);
                    this.rus.add(rus);
                } else {
                    data.forEach(item -> {
                        try {
                            Field currField = item.getClass().getDeclaredField(field.getName());
                            currField.setAccessible(true);
                            currField.set(item, null);
                        } catch (IllegalAccessException | NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }
    }

    public Collection<?> getData() {
        return data;
    }

    public void setData(Collection<?> data) {
        this.data = data;
    }

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    public List<String> getRus() {
        return rus;
    }

    public void setRus(List<String> rus) {
        this.rus = rus;
    }
}
