package domain.services.application;

import domain.models.application.MenuInner;
import domain.services.abstracts.TypoService;
import org.springframework.stereotype.Service;

@Service("menuInnerService")
public class MenuInnerService extends TypoService<MenuInner> {
}
