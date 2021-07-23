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
