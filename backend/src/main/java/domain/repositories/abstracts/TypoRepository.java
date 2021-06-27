package domain.repositories.abstracts;

import domain.models.abstracts.TypoTable;
import kpersistence.QueryGenerator;
import kpersistence.UnnamedParametersQuery;
import kpersistence.mapping.KRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class TypoRepository<T extends TypoTable> {

    Class<T> modelClass;
    protected RowMapper<T> rowMapper;

    public TypoRepository(Class<T> clazz) {
        modelClass = clazz;
        rowMapper = new KRowMapper<>(clazz);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;


    public Optional<T> findOne(long id) {
        String sql = QueryGenerator.generateFindOneQuery(id, modelClass);
        List<T> result = jdbcOperations.query(sql, new Object[]{id}, rowMapper);
        if (result == null || result.size() == 0) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(result.get(0));
        }
    }

    public List<T> findAll() {
        String sql = QueryGenerator.generateSelectAllQuery(modelClass);
        return jdbcOperations.query(sql, rowMapper);
    }

    public Stream<T> streamAll() {
        return findAll().stream();
    }

    public List<T> findWithQuery(String sql) {
        return jdbcOperations.query(sql, rowMapper);
    }


    public void insert(T obj) {
        UnnamedParametersQuery qry = QueryGenerator.generateInsertQuery(obj);
        jdbcOperations.update(qry.getQuery(), qry.getParams());
    }

    public void update(T obj) {
        UnnamedParametersQuery qry = QueryGenerator.generateUpdateQuery(obj);
        jdbcOperations.update(qry.getQuery(), qry.getParams());
    }

    public void delete(T obj) {
        UnnamedParametersQuery qry = QueryGenerator.generateDeleteQuery(obj);
        jdbcOperations.update(qry.getQuery(), qry.getParams());
    }
}
