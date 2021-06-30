package rest.application;

import domain.models.application.MenuMain;
import domain.services.application.MenuMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class MenuController {

    @Autowired
    MenuMainService menuMainService;

    @GetMapping("/application/menu")
    public List<MenuMain> getMenu() {
        return menuMainService.getMenusWithSubmenus();
    }
}
