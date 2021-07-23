package domain.repositories.abstracts;

import kcollections.CollectionFactory;
import kcollections.KList;
import koptional.KOptional;
import kpersistence.QueryGenerator;
import kpersistence.UnnamedParametersQuery;
import kpersistence.mapping.KRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public abstract class AbstractRepository<T> {

    protected Class<T> modelClass;
    protected RowMapper<T> rowMapper;

    public AbstractRepository(Class<T> clazz) {
        modelClass = clazz;
        rowMapper = new KRowMapper<>(clazz);
    }

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Autowired
    protected NamedParameterJdbcOperations namedParameterJdbcOperations;

    public KOptional<T> selectFirst(T obj) {
        UnnamedParametersQuery selectQuery = QueryGenerator.generateSelectSimilarQuery(obj);
        KList<T> res = CollectionFactory.makeListFrom(jdbcOperations::query, selectQuery.getQuery(), selectQuery.getParams(), rowMapper);
        return res.getFirst();
    }

    public Optional<T> findOne(long id) {
        String sql = QueryGenerator.generateSelectOneQuery(id, modelClass);
        List<T> result = jdbcOperations.query(sql, new Object[]{id}, rowMapper);
        if (result == null || result.size() == 0) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(result.get(0));
        }
    }

    public KList<T> selectAll() {
        String sql = QueryGenerator.generateSelectAllQuery(modelClass);
        return CollectionFactory.makeListFrom(jdbcOperations::query, sql, rowMapper);
    }

    public Stream<T> streamAll() {
        return selectAll().stream();
    }

    public KList<T> selectSimilar(T obj) {
        UnnamedParametersQuery selectQuery = QueryGenerator.generateSelectSimilarQuery(obj);

        System.out.println(selectQuery.getQuery());

        KList<T> res = CollectionFactory.makeListFrom(jdbcOperations::query, selectQuery.getQuery(), selectQuery.getParams(), rowMapper);

        return res;
    }

    public KList<T> selectWithQuery(String sql) {
        return CollectionFactory.makeListFrom(jdbcOperations::query, sql, rowMapper);
    }

    public <V> KList<T> selectByField(BiConsumer<T, V> fieldSetter, V fieldValue) {
        try {
            T instance = modelClass.getDeclaredConstructor().newInstance();
            fieldSetter.accept(instance, fieldValue);

            return selectSimilar(instance);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            return CollectionFactory.makeLinkedList();
        }
    }
}
