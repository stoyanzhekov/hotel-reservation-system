/**
 * 
 */
package bg.hotel.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.hotel.entities.User;
import bg.hotel.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService 
{
	//@Autowired 
	private UserRepository userRepository;
	
	public List<User> findAllUsers() {
		ArrayList<User> users = new ArrayList<>();
		users.add(createUser("Ivan", 3));
		users.add(createUser("Jonh", 2));
		return users;
	}
	
	private User createUser(String name, Integer id){
		return new User(name, id);
	}
	
}
