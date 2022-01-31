package domain.repositories.stock;

import domain.models.stock.PurchasedConsumablesBalanceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import repository.AbstractViewRepository;

@Repository
public class PurchasedConsumablesBalanceViewRepository extends AbstractViewRepository<PurchasedConsumablesBalanceView> {

    public PurchasedConsumablesBalanceViewRepository() {
        super(PurchasedConsumablesBalanceView.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}