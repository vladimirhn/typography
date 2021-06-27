package domain.repositories.application;

import domain.models.application.User;
import domain.repositories.abstracts.TypoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UsersRepository extends TypoRepository<User> {

    public UsersRepository() {
        super(User.class);
    }
}
