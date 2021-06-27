package domain.repositories.application;

import domain.models.application.MenuMain;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MenuMainRepository extends TypoRepository<MenuMain> {

    public MenuMainRepository() {
        super(MenuMain.class, true);
    }
}
