package domain.repositories.nomenclature;

import domain.models.nomenclature.NomenclatureGroups;
import domain.repositories.abstracts.TypoRepository;
import kpersistence.QueryGenerator;
import kpersistence.UnnamedParametersQuery;
import kpersistence.exceptions.AnnotationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class NomenclatureGroupsRepository extends TypoRepository<NomenclatureGroups> {

    public NomenclatureGroupsRepository() {
        super(NomenclatureGroups.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;

    public void test() {
        try {
            NomenclatureGroups mm = new NomenclatureGroups();

            UnnamedParametersQuery qry = QueryGenerator.generateInsertQuery(mm);
            jdbcOperations.update(qry.getQuery(), qry.getParams());

        } catch (AnnotationException e) {
            e.printStackTrace();
        }
    }
}
