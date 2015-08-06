package bg.hotel.repositories;

import org.springframework.data.repository.CrudRepository;
import bg.hotel.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	User findUserByUsernameAndPassword(String usename, String passowrd);
}
