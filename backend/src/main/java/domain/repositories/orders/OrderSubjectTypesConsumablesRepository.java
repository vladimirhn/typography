package domain.repositories.orders;

import domain.models.orders.OrderSubjectTypesConsumables;
import kpersistence.repository.TypoTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class OrderSubjectTypesConsumablesRepository extends TypoTableRepository<OrderSubjectTypesConsumables> {

    public OrderSubjectTypesConsumablesRepository() {
        super(OrderSubjectTypesConsumables.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
