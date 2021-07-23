package domain.repositories.nomenclature.equipment;

import domain.models.nomenclature.equipment.ComponentType;
import domain.repositories.abstracts.TypoTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class ComponentTypesRepository extends TypoTableRepository<ComponentType> {

    public ComponentTypesRepository() {
        super(ComponentType.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
