package domain.services.application;

import domain.models.application.User;
import domain.repositories.abstracts.TypoRepository;
import domain.repositories.application.UsersRepository;
import domain.services.abstracts.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersService extends TypoService<User> {

    @Autowired
    UsersRepository repository;

    @Override
    protected TypoRepository<User> getRepository() {
        return repository;
    }
}
