package domain.repositories.application;

import domain.models.application.User;
import repository.AbstractTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository extends AbstractTableRepository<User> {

    public UsersRepository() {
        super(User.class);
    }
}
