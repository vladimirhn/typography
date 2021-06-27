package rest;

import domain.models.application.MenuInner;
import domain.models.application.MenuMain;
import domain.repositories.application.MenuMainRepository;
import domain.repositories.application.UsersRepository;
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
    MenuMainRepository menuMainRepository;

    @GetMapping("/test")
    public List<MenuMain> greeting() {

        menuMainRepository.test();

        List<MenuMain> res = new ArrayList<>();

        MenuMain mm1 = new MenuMain();
        MenuMain mm2 = new MenuMain();
        mm1.setEntry("Пункт 1"); mm1.setEntryCode("Entry 1");
        mm2.setEntry("Пункт 2"); mm2.setEntryCode("Entry 2");


        MenuInner mi1 = new MenuInner();
        MenuInner mi2 = new MenuInner();
        mi1.setEntry("Подпункт 1"); mi1.setEntryCode("Subentry 1");
        mi2.setEntry("Подпункт 2"); mi2.setEntryCode("Subentry 2");

        List<MenuInner> l1 = new ArrayList<>();
        l1.add(mi1); l1.add(mi2);

        List<MenuInner> l2 = new ArrayList<>();
        l2.add(mi1); l2.add(mi2);

        mm1.setSubEntries(l1);
        mm2.setSubEntries(l2);

        res.add(mm1);
        res.add(mm2);

        return res;
    }
}
