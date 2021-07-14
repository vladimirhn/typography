package domain.repositories.nomenclature.consumables;

import domain.models.nomenclature.consumables.ConsumableType;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumableTypesRepository extends TypoRepository<ConsumableType> {

    public ConsumableTypesRepository() {
        super(ConsumableType.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}