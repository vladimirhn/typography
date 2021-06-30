package domain.services.application;

import domain.models.application.MenuInner;
import domain.models.application.MenuMain;
import domain.repositories.application.MenuMainRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuMainService")
public class MenuMainService extends TypoService<MenuMain> {

    @Autowired
    MenuMainRepository repository;
    
    @Autowired
    MenuInnerService menuInnerService;
    
    public List<MenuMain> getMenusWithSubmenus() {
        List<MenuMain> mainMenus = repository.findAll();

        mainMenus.forEach(menu -> {
            List<MenuInner> subMenus = menuInnerService.findByParentCode(menu.getEntryCode());
            menu.setSubEntries(subMenus);
        });

        return mainMenus;
    }
}
