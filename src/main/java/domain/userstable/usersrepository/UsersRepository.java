package domain.userstable.usersrepository;

import domain.userstable.entity.User;
import org.springframework.data.repository.CrudRepository;


public interface UsersRepository extends CrudRepository<User,Long>{
    User getUserByUsername(String username);
}
