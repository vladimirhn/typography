package domain.repositories.application;

import domain.models.application.User;
import kpersistence.KRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository extends KRepository<User> {

    public UsersRepository() {
        super(User.class, id -> id.getId().toString());
    }
}
