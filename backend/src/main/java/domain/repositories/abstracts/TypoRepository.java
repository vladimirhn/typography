package domain.repositories.abstracts;

import domain.models.abstracts.TypoTable;
import domain.services.application.IdService;
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

public abstract class TypoRepository<T extends TypoTable> {

    Class<T> modelClass;
    protected RowMapper<T> rowMapper;

    public TypoRepository(Class<T> clazz) {
        modelClass = clazz;
        rowMapper = new KRowMapper<>(clazz);
    }

    @Autowired
    protected IdService idService;

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


    public void insert(T obj) {
        if (obj.getId() == null) obj.setId(idService.next());
        UnnamedParametersQuery qry = QueryGenerator.generateInsertQuery(obj);
        jdbcOperations.update(qry.getQuery(), qry.getParams());
    }

    public Long insertIfNew(T obj) {

        UnnamedParametersQuery countQuery = QueryGenerator.generateSelectCountSimilarQuery(obj);
        Long amount = jdbcOperations.queryForObject(countQuery.getQuery(), countQuery.getParams(), Long.class);

        if (amount == 0L) {
            Long id = idService.next();
            obj.setId(id);
            UnnamedParametersQuery insertQuery = QueryGenerator.generateInsertQuery(obj);
            jdbcOperations.update(insertQuery.getQuery(), insertQuery.getParams());

            return id;
        }

        UnnamedParametersQuery selectQuery = QueryGenerator.generateSelectSimilarQuery(obj);
        return jdbcOperations.query(selectQuery.getQuery(), selectQuery.getParams(), rowMapper).get(0).getId();
    }

    public void update(T obj) {
        UnnamedParametersQuery qry = QueryGenerator.generateUpdateQuery(obj);
        jdbcOperations.update(qry.getQuery(), qry.getParams());
    }

    public void delete(Long id) {
        try {
            T instance = modelClass.getDeclaredConstructor().newInstance();
            instance.setId(id);

            UnnamedParametersQuery qry = QueryGenerator.generateDeleteQuery(instance);
            jdbcOperations.update(qry.getQuery(), qry.getParams());

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
