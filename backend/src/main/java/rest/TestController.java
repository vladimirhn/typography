package rest;

import domain.models.application.User;
import domain.repositories.application.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TestController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/test")
    public DDate greeting() {

        User admin = new User();
        admin.setName("Admin");
        usersRepository.insert(admin);

        return new DDate();
    }
}
