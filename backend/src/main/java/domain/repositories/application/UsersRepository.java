package domain.repositories.application;

import domain.models.application.User;
import domain.repositories.abstracts.TypoTableRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository extends TypoTableRepository<User> {

    public UsersRepository() {
        super(User.class);
    }
}
