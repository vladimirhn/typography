package domain.repositories.enterprises;

import domain.models.enterprises.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import repository.AbstractTableRepository;

@Repository
public class EnterprisesRepository extends AbstractTableRepository<Enterprise> {

    public EnterprisesRepository() {
        super(Enterprise.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
