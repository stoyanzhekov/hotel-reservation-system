package bg.hotel.services.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import bg.hotel.entities.User;
import bg.hotel.repositories.UserRepository;
import bg.hotel.services.UserService;

@Named(value="userService")
@Transactional(value=TxType.SUPPORTS)
public class UserServiceImpl implements UserService{

	@Inject
	private UserRepository userRepository;
	
	@Override
	public User findUserByUsernameAndPassword(String usename, String passowrd) {
		return userRepository.findUserByUsernameAndPassword(usename, passowrd);
	}

}
