package domain.repositories.stock;

import domain.models.stock.OrderConsumedConsumablesBalanceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import repository.v1.AbstractViewRepository;

@Repository
public class OrderConsumedConsumablesBalanceViewRepository extends AbstractViewRepository<OrderConsumedConsumablesBalanceView> {

    public OrderConsumedConsumablesBalanceViewRepository() {
        super(OrderConsumedConsumablesBalanceView.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
