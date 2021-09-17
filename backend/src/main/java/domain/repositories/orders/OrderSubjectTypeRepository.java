package domain.repositories.orders;

import domain.models.orders.OrderSubjectType;
import kpersistence.repository.TypoTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class OrderSubjectTypeRepository extends TypoTableRepository<OrderSubjectType> {

    public OrderSubjectTypeRepository() {
        super(OrderSubjectType.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
