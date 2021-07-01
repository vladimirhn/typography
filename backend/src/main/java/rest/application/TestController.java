package rest.application;

import domain.models.nomenclature.NomenclatureGroups;
import domain.repositories.application.UsersRepository;
import domain.repositories.nomenclature.NomenclatureGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
public class TestController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    NomenclatureGroupsRepository nomenclatureGroupsRepository;

    @GetMapping("/test")
    public List<NomenclatureGroups> greeting() {

        nomenclatureGroupsRepository.test();

        List<NomenclatureGroups> res = new ArrayList<>();

        return res;
    }
}
