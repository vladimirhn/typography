package kpersistence.mapping;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import kpersistence.exceptions.IncorrectTypeException;
import kpersistence.mapping.annotations.Column;

public class RowMapper {

    public static <T> T mapRowToObject(ResultSet rs, Class<T> type) throws IncorrectTypeException {

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
                                    Logger.getLogger(RowMapper.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                return null;
                            });
                            break;

                        case "java.lang.Integer":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getInt(string);
                                } catch (SQLException ex) {
                                    Logger.getLogger(RowMapper.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                return null;
                            });
                            break;

                        case "java.lang.String":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getString(string);
                                } catch (SQLException ex) {
                                    Logger.getLogger(RowMapper.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                return null;
                            });
                            break;

                        case "java.lang.Double":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getDouble(string);
                                } catch (SQLException ex) {
                                    Logger.getLogger(RowMapper.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                return null;
                            });
                            break;

                        case "java.lang.Boolean":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getBoolean(string);
                                } catch (SQLException ex) {
                                    Logger.getLogger(RowMapper.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                return null;
                            });
                            break;

                        case "java.math.BigDecimal":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getBigDecimal(string);
                                } catch (SQLException ex) {
                                    Logger.getLogger(RowMapper.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                return null;
                            });
                            break;

                        case "java.util.Date":
                            setValues(obj, field, string -> {
                                try {
                                    return rs.getDate(string);
                                } catch (SQLException ex) {

                                    try {
                                        return new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString(string));

                                    } catch (ParseException | SQLException ex0) {

                                        try {
                                            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(rs.getString(string));
                                        } catch (ParseException | SQLException ex1) {
                                            Logger.getLogger(RowMapper.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                }
                                return null;
                            });
                            break;

                        case "java.time.LocalDate":
                            setValues(obj, field, string -> {
                                try {
                                    java.sql.Date sqlDate = rs.getDate(string);
                                    return  sqlDate.toLocalDate();
                                } catch (SQLException ex) {
                                    try {
                                        return LocalDate.parse(rs.getString(string));
                                    } catch(SQLException ex1) {ex1.printStackTrace();}
                                }
                                return null;
                            });
                            break;
                    }
                }

            }

            return obj;

        } catch (NoSuchMethodException ex) {
            throw new IncorrectTypeException("Не удаётся обработать модель. У модели обязан быть конструктор без параметров.");

        } catch (SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            Logger.getLogger(RowMapper.class.getName()).log(Level.SEVERE, null, ex);

            throw new IncorrectTypeException("Не удаётся обработать модель. См. детали в логе.");
        }
    }

    private static void setValues(Object obj, Field field, Function<String,?> getter) {

        String colName = field.getAnnotation(Column.class).name();
        String fieldName = field.getName();

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
