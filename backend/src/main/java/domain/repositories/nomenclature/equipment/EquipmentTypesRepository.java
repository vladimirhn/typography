package domain.repositories.nomenclature.equipment;

import domain.models.nomenclature.equipment.EquipmentType;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class EquipmentTypesRepository extends TypoRepository<EquipmentType> {

    public EquipmentTypesRepository() {
        super(EquipmentType.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;
}
