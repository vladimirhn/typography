package domain.repositories.purchasing;

import domain.models.purchasing.PurchasingConsumables;
import kpersistence.repository.TypoTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class PurchasingConsumablesRepository extends TypoTableRepository<PurchasingConsumables> {

    public PurchasingConsumablesRepository() {
        super(PurchasingConsumables.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
