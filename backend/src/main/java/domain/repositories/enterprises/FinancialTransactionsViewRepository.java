package domain.repositories.enterprises;

import domain.models.enterprises.FinancialTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import repository.AbstractViewRepository;

@Repository
public class FinancialTransactionsViewRepository extends AbstractViewRepository<FinancialTransaction> {

    public FinancialTransactionsViewRepository() {
        super(FinancialTransaction.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
