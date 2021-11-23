package domain.repositories.counterparties;

import domain.models.counterparties.LegalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import repository.AbstractTableRepository;

@Repository
public class LegalEntitiesRepository extends AbstractTableRepository<LegalEntity> {

    public LegalEntitiesRepository() {
        super(LegalEntity.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
