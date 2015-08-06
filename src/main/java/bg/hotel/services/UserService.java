package bg.hotel.services;

import bg.hotel.entities.User;

public interface UserService {

	User findUserByUsernameAndPassword(String usename, String passowrd);
}
