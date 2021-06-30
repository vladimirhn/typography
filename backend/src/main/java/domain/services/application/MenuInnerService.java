package domain.services.application;

import domain.models.application.MenuInner;
import domain.repositories.application.MenuInnerRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuInnerService")
public class MenuInnerService extends TypoService<MenuInner> {

    @Autowired
    MenuInnerRepository repository;

    public List<MenuInner> findByParentCode(String parentCode) {
        return repository.findByParentCode(parentCode);
    }
}
