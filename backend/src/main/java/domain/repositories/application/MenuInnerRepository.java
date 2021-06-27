package domain.repositories.application;

import domain.models.application.MenuInner;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MenuInnerRepository extends TypoRepository<MenuInner> {

    public MenuInnerRepository() {
        super(MenuInner.class);
    }
}
