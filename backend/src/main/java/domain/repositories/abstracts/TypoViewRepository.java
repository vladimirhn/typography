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

public abstract class TypoViewRepository<T extends TypoView> extends AbstractRepository<T> {

    public TypoViewRepository(Class<T> clazz) {
        super(clazz);
    }

    @Autowired
    protected JdbcOperations jdbcOperations;

    @Autowired
    protected NamedParameterJdbcOperations namedParameterJdbcOperations;

}
