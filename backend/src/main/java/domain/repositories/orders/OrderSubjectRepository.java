package domain.repositories.orders;

import domain.models.orders.OrderSubject;
import domain.repositories.abstracts.TypoTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class OrderSubjectRepository extends TypoTableRepository<OrderSubject> {

    public OrderSubjectRepository() {
        super(OrderSubject.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
