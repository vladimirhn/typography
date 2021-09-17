package domain.repositories.stock;

import domain.models.stock.StockBalance;
import kpersistence.repository.TypoTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class StockBalanceRepository extends TypoTableRepository<StockBalance> {

    public StockBalanceRepository() {
        super(StockBalance.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
