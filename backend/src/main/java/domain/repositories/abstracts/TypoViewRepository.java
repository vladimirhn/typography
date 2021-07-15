package domain.repositories.abstracts;

import domain.models.abstracts.TypoView;
import kcollections.CollectionFactory;
import kcollections.KList;
import kpersistence.QueryGenerator;
import kpersistence.mapping.KRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class TypoViewRepository<T extends TypoView> {

    Class<T> modelClass;
    protected RowMapper<T> rowMapper;

    public TypoViewRepository(Class<T> clazz) {
        modelClass = clazz;
        rowMapper = new KRowMapper<>(clazz);
    }

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Autowired
    protected NamedParameterJdbcOperations namedParameterJdbcOperations;


    public Optional<T> findOne(long id) {
        String sql = QueryGenerator.generateSelectOneQuery(id, modelClass);
        List<T> result = jdbcOperations.query(sql, new Object[]{id}, rowMapper);
        if (result == null || result.size() == 0) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(result.get(0));
        }
    }

    public KList<T> findAll() {
        String sql = QueryGenerator.generateSelectAllQuery(modelClass);
        return CollectionFactory.makeList(jdbcOperations.query(sql, rowMapper));
    }

    public Stream<T> streamAll() {
        return findAll().stream();
    }

    public List<T> findWithQuery(String sql) {
        return jdbcOperations.query(sql, rowMapper);
    }
}
