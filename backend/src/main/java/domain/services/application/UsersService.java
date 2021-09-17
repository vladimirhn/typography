package domain.services.application;

import domain.models.application.User;
import repository.AbstractTableRepository;
import domain.repositories.application.UsersRepository;
import service.TypoTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersService extends TypoTableService<User> {

    @Autowired
    UsersRepository repository;

    @Override
    protected AbstractTableRepository<User> getRepository() {
        return repository;
    }
}
