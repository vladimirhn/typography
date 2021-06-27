package kpersistence;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import kpersistence.exceptions.AnnotationException;
import kpersistence.exceptions.TableAnnotationException;
import kpersistence.mapping.annotations.Table;
import kpersistence.mapping.annotations.Column;
import kpersistence.mapping.annotations.Entity;
import kpersistence.mapping.annotations.Id;

public class QueryGenerator {

    public static String generateFindOneQuery(long id, Class<?> type) throws AnnotationException {
        String tableName = extractTableName(type);
        String idColumn = extractIdColumnName(type);

        return "SELECT * FROM " + tableName + " WHERE " + idColumn + " = " + id;
    }

    public static <T> String generateSelectAllQuery(Class<T> type) throws AnnotationException {

        String tableName = extractTableName(type);

        return "SELECT * FROM " + tableName;

    }

    public static UnnamedParametersQuery generateInsertQuery(Object obj) throws AnnotationException {

        Map<String, Object> columnsToValues = getColumnToValues(obj);

        String sql = generateInsertQuerySql(extractTableName(obj.getClass()), columnsToValues);
        List<Object> values = new ArrayList<>(columnsToValues.size());

        columnsToValues.keySet().forEach(col -> {
            values.add(columnsToValues.get(col));
        });

        return new UnnamedParametersQuery(sql, values);
    }

    private static String generateInsertQuerySql(String tableName, Map<String, Object> columnsToValues) {

        int columnsNumber = columnsToValues.size();

        List<String> columns = new ArrayList<>(columnsNumber);

        columnsToValues.keySet().forEach(col -> {
            columns.add(col);
        });

        String columnsPart = columns.stream().sequential().collect(Collectors.joining(", ", "(", ")"));

        List<String> questMarks = new ArrayList<>();
        for (int i = 0; i < columnsNumber; i++) {
            questMarks.add("?");
        }

        String questMarksPart = questMarks.stream().collect(Collectors.joining(", ", "(", ")"));

        return "INSERT INTO " + tableName + " " + columnsPart + " VALUES " + questMarksPart;
    }

    public static UnnamedParametersQuery generateUpdateQuery(Object obj) throws AnnotationException {

        Map<String, Object> columnsToValues = getColumnToValues(obj);
        String idColumn = extractIdColumnName(obj);
        Object idValue = columnsToValues.get(idColumn);
        columnsToValues.remove(idColumn);//Must be last in WHERE clause

        String sql = generateUpdateQuerySql(extractTableName(obj.getClass()), columnsToValues);
        List<Object> values = new ArrayList<>(columnsToValues.size());

        columnsToValues.keySet().forEach(col -> {
            values.add(columnsToValues.get(col));
        });

        values.add(idValue);//Must be last in WHERE clause

        System.out.println("Update query: " + sql);

        return new UnnamedParametersQuery(sql, values);
    }

    private static String generateUpdateQuerySql(String tableName, Map<String, Object> columnsToValues) {

        String setPart = columnsToValues.keySet().stream()
                .map(col -> col + " = ?").collect(Collectors.joining(", "));

        return "UPDATE " + tableName + " SET " + setPart + " WHERE ID = ?";
    }

    public static UnnamedParametersQuery generateDeleteQuery(Object obj) throws AnnotationException {
        Map<String, Object> columnsToValues = getColumnToValues(obj);
        String idColumn = extractIdColumnName(obj);
        Object idValue = columnsToValues.get(idColumn);

        String sql = generateDeleteQuerySql(extractTableName(obj.getClass()), idColumn);
        List<Object> values = new ArrayList<>(columnsToValues.size());
        values.add(idValue);

        System.out.println("Delete query: " + sql);

        return new UnnamedParametersQuery(sql, values);
    }

    private static String generateDeleteQuerySql(String tableName, String idColumn) {
        return "DELETE FROM " + tableName + " WHERE " + idColumn + " = ?";
    }

    private static Map<String, Object> getColumnToValues(Object obj) {

        Class<?> type = obj.getClass();
        Map<String, Object> columnToValues = new TreeMap<>();

        for (Field field : type.getDeclaredFields()) {

            field.setAccessible(true);
            Object value = null;
                try {
                    value = field.get(obj);
                } catch (IllegalAccessException ex) {}

            if (field.isAnnotationPresent(Column.class) && value != null) {

                columnToValues.put(field.getAnnotation(Column.class).name(), value);
            }

        }
        return columnToValues;
    }

    private static String extractIdColumnName(Object obj) {

        String idColumn = null;

        Class<?> type = obj.getClass();

        for (Field field : type.getDeclaredFields()) {

            field.setAccessible(true);

            if (field.isAnnotationPresent(Column.class) && field.isAnnotationPresent(Id.class)) {
                idColumn = field.getAnnotation(Column.class).name();
            }

        }
        return idColumn;
    }

    private static String extractIdColumnName(Class<?> type) {

        String idColumn = null;

        for (Field field : type.getDeclaredFields()) {

            field.setAccessible(true);

            if (field.isAnnotationPresent(Column.class) && field.isAnnotationPresent(Id.class)) {
                idColumn = field.getAnnotation(Column.class).name();
            }

        }
        return idColumn;
    }

    private static String extractTableName(Class<?> type) throws AnnotationException {

        if (!type.isAnnotationPresent(Table.class)) {
            throw new TableAnnotationException("Аннотация @Table не найдена");
        }

        String tableName = type.getAnnotation(Table.class).name();

        if (!isProperDbEntityName(tableName)) {
            throw new AnnotationException("Недопустимое имя для таблицы базы данных.");
        }

        return tableName;
    }

    private static boolean isProperDbEntityName(String name) {
        return name != null && Pattern.matches("[a-zA-Z0-9_]+", name);
    }

//    public static void main(String[] args) throws Exception {
//
//        Texts t = new Texts();
//        t.id = 100;
//        t.rus = "zzz";
//        t.text = "yyy";
//        t.transcription = "xxx";
//
//        System.out.println(generateFindOneQuery(1, Texts.class));
//    }
}

//@Entity
//@Table(name = "texts")
//class Texts {
//
//    @Id
//    @Column(name = "id")
//    Integer id;
//    @Column(name = "text")
//    String text;
//    @Column(name = "transcription")
//    String transcription;
//    @Column(name = "rus")
//    String rus;
//
//    public Texts() {
//    }
//}