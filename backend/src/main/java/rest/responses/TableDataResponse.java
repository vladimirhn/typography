package rest.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import domain.services.ServiceUser;
import kutils.ClassUtils;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TableDataResponse<T> implements ServiceUser {

    List<T> data;
    List<String> properties = new LinkedList<>();
    List<String> trans = new LinkedList<>();

    public TableDataResponse(List<T> data) {
        if (data == null) data = new LinkedList<>();
        this.data = data.stream().filter(Objects::nonNull).collect(Collectors.toList());

        definePropertiesAndTranslations();
    }

    private void definePropertiesAndTranslations() {
        if (!data.isEmpty() && data.stream().anyMatch(Objects::nonNull)) {
            Class<?> type = data.get(0).getClass();
            for (Field field : ClassUtils.getFieldsUpToObject(type)) {
                boolean isWriteOnly =
                        field.isAnnotationPresent(JsonProperty.class)
                     && JsonProperty.Access.WRITE_ONLY.equals(field.getAnnotation(JsonProperty.class).access());

                if (!isWriteOnly) {
                    properties.add(field.getName());
                    String translation = dictionaryService.russian(field.getName());
                    trans.add(translation == null ? field.getName() : translation);
                }
            }
        }
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    public List<String> getTrans() {
        return trans;
    }

    public void setTrans(List<String> trans) {
        this.trans = trans;
    }
}
