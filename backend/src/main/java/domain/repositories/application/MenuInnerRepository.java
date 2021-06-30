package domain.repositories.application;

import domain.models.application.MenuInner;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuInnerRepository extends TypoRepository<MenuInner> {

    public MenuInnerRepository() {
        super(MenuInner.class);
    }

    public List<MenuInner> findByParentCode(String parentCode) {
        String sql = "SELECT * FROM MENU_INNER WHERE PARENT_CODE = ?";
        return jdbcOperations.query(sql, new Object[]{parentCode}, rowMapper);
    }
}
