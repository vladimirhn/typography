package domain.repositories.orders;

import domain.models.orders.OrderConsumable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import repository.v1.AbstractTableRepository;

@Repository
public class OrderConsumableRepository extends AbstractTableRepository<OrderConsumable> {

    public OrderConsumableRepository() {
        super(OrderConsumable.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
