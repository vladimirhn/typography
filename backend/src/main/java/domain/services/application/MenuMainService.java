package domain.services.application;

import domain.models.application.MenuMain;
import domain.services.abstracts.TypoService;
import org.springframework.stereotype.Service;

@Service("menuMainService")
public class MenuMainService extends TypoService<MenuMain> {
}
