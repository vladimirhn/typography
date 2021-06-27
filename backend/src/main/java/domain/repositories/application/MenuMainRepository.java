package domain.repositories.application;

import domain.models.application.MenuMain;
import domain.repositories.abstracts.TypoRepository;
import kpersistence.QueryGenerator;
import kpersistence.UnnamedParametersQuery;
import kpersistence.exceptions.AnnotationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class MenuMainRepository extends TypoRepository<MenuMain> {

    public MenuMainRepository() {
        super(MenuMain.class);
    }

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations namedParameterJdbcOperations;

    public void test() {
        try {
            MenuMain mm = new MenuMain();
            mm.setEntryCode("NEWONE");
            mm.setEntry("Новый");

            UnnamedParametersQuery qry = QueryGenerator.generateInsertQuery(mm);
            jdbcOperations.update(qry.getQuery(), qry.getParams());

        } catch (AnnotationException e) {
            e.printStackTrace();
        }
    }
}
