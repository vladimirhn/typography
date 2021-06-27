package kpersistence.mapping;

import kpersistence.mapping.annotations.Column;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Function;
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

            for (Field field : type.getDeclaredFields()) {

                field.setAccessible(true);

                if (field.isAnnotationPresent(Column.class)) {

                    String colName = field.getAnnotation(Column.class).name();

                    switch (field.getType().getName()) {

                        case "java.lang.Long":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getLong(string);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                return null;
                            });
                            break;

                        case "java.lang.Integer":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getInt(string);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                return null;
                            });
                            break;

                        case "java.lang.String":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getString(string);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                return null;
                            });
                            break;

                        case "java.lang.Double":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getDouble(string);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                return null;
                            });
                            break;

                        case "java.lang.Boolean":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getBoolean(string);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                return null;
                            });
                            break;

                        case "java.math.BigDecimal":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getBigDecimal(string);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                return null;
                            });
                            break;

                        case "java.util.Date":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getTimestamp(string);
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                return null;
                            });
                            break;
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

    private void setValues(Object obj, Field field, Function<String,?> getter) {

        String colName = field.getAnnotation(Column.class).name();

        Object value = getter.apply(colName);

        for (Field objField : obj.getClass().getDeclaredFields()) {

            if (objField.getName().equals(field.getName())) {
                objField.setAccessible(true);

                try {
                    objField.set(obj, value);
                } catch (IllegalAccessException e) { }

            }

        }
    }
}
