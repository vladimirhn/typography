package domain.services.application;

import domain.models.application.User;
import domain.repositories.abstracts.TypoTableRepository;
import domain.repositories.application.UsersRepository;
import domain.services.abstracts.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersService extends TypoTableService<User> {

    @Autowired
    UsersRepository repository;

    @Override
    protected TypoTableRepository<User> getRepository() {
        return repository;
    }
}
