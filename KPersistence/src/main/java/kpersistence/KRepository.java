package kpersistence;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Stream;
import kpersistence.exceptions.AnnotationException;
import kpersistence.mapping.RowMapper;


public abstract class KRepository<T> {

    private static String connectionUrl;
    public static void setConnectionUrl(String url) { connectionUrl = url; }

    private final Class<T> type;
    private final Function<T, String> idStringGetter;

    protected List<T> cache;
    protected Map<String, T> idStringToItem;

    protected final List<KChangeListener> listeners = new ArrayList<>();

    public KRepository(Class<T> type, Function<T, String> idStringGetter) {
        this.type = type;
        this.idStringGetter = idStringGetter;

        refreshCache();
    }

    public void registerListener(KChangeListener listener) {
        listeners.add(listener);
    }

    public Optional<T> findOne(long id) {
        T result = null;

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement  stmt = conn.createStatement();) {

            String sql = QueryGenerator.generateFindOneQuery(id, type);
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                result = RowMapper.mapRowToObject(rs, type);
            }

        } catch (Exception e) {e.printStackTrace();}

        return Optional.ofNullable(result);
    }

    private List<T> retrieveAll() {

        List<T> result = new LinkedList<>();

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement  stmt = conn.createStatement();) {

            String sql = QueryGenerator.generateSelectAllQuery(type);

            System.out.println(sql);

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                result.add(RowMapper.mapRowToObject(rs, type));
            }

        } catch (Exception e) {e.printStackTrace();}
        return result;
    }

    public List<T> findAll() {
        return cache;
    }

    public List<T> findAll(Function<? super T, ? extends Comparable> compareBy) {
        List<T> res = new ArrayList<>(cache.size());
        res.addAll(cache);
        res.sort(Comparator.comparing(compareBy));
        return res;
    }

    public Stream<T> streamAll() {
        return cache.stream();
    }

     public Stream<T> streamAll(Function<? super T, ? extends Comparable> compareBy) {
        return findAll(compareBy).stream();
    }

    public List<T> findWithQuery(String sql) {
        List<T> result = new LinkedList<>();

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement  stmt = conn.createStatement();) {

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                result.add(RowMapper.mapRowToObject(rs, type));
            }

        } catch (Exception e) {e.printStackTrace();}
        return result;
    }

    public void insert(T obj) {

        UnnamedParametersQuery query = null;

        try {
            query = QueryGenerator.generateInsertQuery(obj);

        } catch (AnnotationException e) {e.printStackTrace();}

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             PreparedStatement stmt = conn.prepareStatement(query.getQuery());) {

            int i = 1;

            for (Object value : query.getParams()) {

                switch (value.getClass().getName()) {
                    case "java.lang.Long":
                            stmt.setLong(i++, (Long) value);
                            break;

                        case "java.lang.Integer":
                            stmt.setInt(i++, (Integer) value);
                            break;

                        case "java.lang.String":
                            stmt.setString(i++, (String) value);
                            break;

                        case "java.lang.Double":
                            stmt.setDouble(i++, (Double) value);
                            break;

                        case "java.lang.Boolean":
                            stmt.setBoolean(i++, (Boolean) value);
                            break;

                        case "java.math.BigDecimal":
                            stmt.setBigDecimal(i++, (BigDecimal) value);
                            break;

                        case "java.util.Date":
                            stmt.setDate(i++, new java.sql.Date(((Date)value).getTime()));
                            break;

                        case "java.time.LocalDate":
                            stmt.setDate(i++, new java.sql.Date(((LocalDate)value).atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()));
                            break;
                }

            }

            stmt.executeUpdate();

        } catch (Exception e) {e.printStackTrace();}

        processChanges();
    }

    public void update(T obj) {

        UnnamedParametersQuery query = null;

        try {
            query = QueryGenerator.generateUpdateQuery(obj);

        } catch (AnnotationException e) {e.printStackTrace();}

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             PreparedStatement stmt = conn.prepareStatement(query.getQuery());) {

            int i = 1;

            for (Object value : query.getParams()) {

                String className = value.getClass().getName();

                switch (className) {
                    case "java.lang.Long":
                            stmt.setLong(i++, (Long) value);
                            break;

                        case "java.lang.Integer":
                            stmt.setInt(i++, (Integer) value);
                            break;

                        case "java.lang.String":
                            stmt.setString(i++, (String) value);
                            break;

                        case "java.lang.Double":
                            stmt.setDouble(i++, (Double) value);
                            break;

                        case "java.lang.Boolean":
                            stmt.setBoolean(i++, (Boolean) value);
                            break;

                        case "java.math.BigDecimal":
                            stmt.setBigDecimal(i++, (BigDecimal) value);
                            break;

                        case "java.util.Date":
                            stmt.setDate(i++, new java.sql.Date(((Date)value).getTime()));
                            break;

                        case "java.sql.Date":
                            stmt.setDate(i++, (java.sql.Date) value);
                            break;

                            case "java.time.LocalDate":
                            stmt.setDate(i++, new java.sql.Date(((LocalDate)value).atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()));
                            break;
                }

            }

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        processChanges();
    }

    public void delete(T obj) {

        UnnamedParametersQuery query = null;

        try {
            query = QueryGenerator.generateDeleteQuery(obj);

        } catch (AnnotationException e) {e.printStackTrace();}

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             PreparedStatement stmt = conn.prepareStatement(query.getQuery());) {

            Object value = query.getParams().get(0);

                String className = value.getClass().getName();

                switch (className) {
                    case "java.lang.Long":
                            stmt.setLong(1, (Long) value);
                            break;

                        case "java.lang.Integer":
                            stmt.setInt(1, (Integer) value);
                            break;

                        case "java.lang.String":
                            stmt.setString(1, (String) value);
                            break;

                        case "java.lang.Double":
                            stmt.setDouble(1, (Double) value);
                            break;

                        case "java.lang.Boolean":
                            stmt.setBoolean(1, (Boolean) value);
                            break;

                        case "java.math.BigDecimal":
                            stmt.setBigDecimal(1, (BigDecimal) value);
                            break;

                        case "java.util.Date":
                            stmt.setDate(1, new java.sql.Date(((Date)value).getTime()));
                            break;

                        case "java.sql.Date":
                            stmt.setDate(1, (java.sql.Date) value);
                            break;

                        case "java.time.LocalDate":
                            stmt.setDate(1, new java.sql.Date(((LocalDate)value).atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()));
                            break;
                }

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        processChanges();
    }

    private void processChanges() {
        refreshCache();
        announce(cache);
    }

    private void refreshCache() {
        cache = retrieveAll();

        idStringToItem = new TreeMap<>();
        cache.forEach(entry -> {
            idStringToItem.put(idStringGetter.apply(entry), entry);
        });
    }

    protected void announce(List<T> entries) {
        listeners.forEach((KChangeListener listener) -> listener.updateState(entries));
    }

    public Map<String, T> getMap() {
        return idStringToItem;
    }
}
