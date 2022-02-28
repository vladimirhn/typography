package domain.repositories.enterprises;

import domain.models.enterprises.MoneyMovement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import repository.AbstractTableRepository;

@Repository
public class MoneyMovementsRepository extends AbstractTableRepository<MoneyMovement> {

    public MoneyMovementsRepository() {
        super(MoneyMovement.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
