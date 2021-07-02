package kutils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassUtils {

    public static List<Field> getFieldsUpToObject(Class<?> type) {
        List<Field> result = new ArrayList<>();
        return getFieldsUpToObject(result, type);
    }

    private static List<Field> getFieldsUpToObject(List<Field> result, Class<?> type) {
        if (type.getSuperclass() != null) {
            getFieldsUpToObject(result, type.getSuperclass());
        }
        result.addAll(Arrays.asList(type.getDeclaredFields()));
        return result;
    }
}
