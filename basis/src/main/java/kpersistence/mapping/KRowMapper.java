package kpersistence.mapping;

import kpersistence.mapping.annotations.Column;
import kutils.ClassUtils;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KRowMapper<T> implements RowMapper<T> {

    Class<T> type;

    public KRowMapper(Class<T> type) {
        this.type = type;
    }

    @Override
    public T mapRow(ResultSet rs, int i) throws SQLException {
        try {
            T obj = type.getDeclaredConstructor().newInstance();
            List<Field> fields = ClassUtils.getFieldsUpToObject(type);

            for (Field field : fields) {

                field.setAccessible(true);

                if (field.isAnnotationPresent(Column.class)) {

                    String colName = field.getAnnotation(Column.class).name();
                    Object data = rs.getObject(colName);

                    Class<?> fieldType = field.getType();
                    Class<?> dataType = data != null ? data.getClass() : Object.class;

                    if (fieldType.equals(LocalDate.class) && dataType.equals(String.class)) {
                        //new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        field.set(obj, LocalDate.parse(data.toString()));
                    }

                    if (fieldType.equals(LocalDateTime.class) && dataType.equals(String.class)) {
                        field.set(obj, LocalDateTime.parse(data.toString()));
                    }

                    if (fieldType.equals(Long.class) && dataType.equals(Integer.class)) {
                        field.set(obj, (long) (int) data);
                    }

                    if (fieldType.isAssignableFrom(dataType)) {
                        field.set(obj, data);
                    }
                }

            }

            return obj;

        } catch (NoSuchMethodException ex) {
            throw new IllegalArgumentException("Не удаётся обработать модель. У модели обязан быть конструктор без параметров.");

        } catch (SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();

            throw new IllegalArgumentException("Не удаётся обработать модель. См. детали в логе.");
        }
    }
}
