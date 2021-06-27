package domain.services.application;

import domain.models.application.User;
import domain.services.abstracts.TypoService;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersService extends TypoService<User> {
}
