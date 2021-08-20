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

public abstract class TypoTableRepository<T extends TypoTable> extends AbstractRepository<T> {

    public TypoTableRepository(Class<T> clazz) {
        super(clazz);
    }

    @Autowired
    protected IdService idService;

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Autowired
    protected NamedParameterJdbcOperations namedParameterJdbcOperations;

    public String insert(T obj) {
        String id = idService.next();
        if (obj.getId() == null) obj.setId(id);
        obj.setDefaults();
        UnnamedParametersQuery qry = QueryGenerator.generateInsertQuery(obj);
        jdbcOperations.update(qry.getQuery(), qry.getParams());

        return id;
    }

    public String insertIfNew(T obj) {

        UnnamedParametersQuery countQuery = QueryGenerator.generateSelectCountSimilarQuery(obj);
        Long amount = jdbcOperations.queryForObject(countQuery.getQuery(), countQuery.getParams(), Long.class);

        if (amount == 0L) {
            String id = idService.next();
            obj.setId(id);
            obj.setDefaults();
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

    public void delete(String id) {
        try {
            T instance = modelClass.getDeclaredConstructor().newInstance();
            instance.setId(id);

            UnnamedParametersQuery qry = QueryGenerator.generateDeleteQuery(instance);
            jdbcOperations.update(qry.getQuery(), qry.getParams());

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void deleteSimilar(T obj) {
        UnnamedParametersQuery deleteQuery = QueryGenerator.generateDeleteSimilarQuery(obj);

        System.out.println(deleteQuery.getQuery());

        jdbcOperations.update(deleteQuery.getQuery(), deleteQuery.getParams());
    }

    public <V> void deleteByField(BiConsumer<T, V> fieldSetter, V fieldValue) {
        try {
            T instance = modelClass.getDeclaredConstructor().newInstance();
            fieldSetter.accept(instance, fieldValue);

            deleteSimilar(instance);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
