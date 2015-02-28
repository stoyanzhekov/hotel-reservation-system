/**
 * 
 */
package bg.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bg.hotel.entities.User;
import bg.hotel.services.UserService;

/**
 * @author Siva
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/welcome")
	public String welcome(Model model) 
	{
		List<User> blogs = userService.findAllUsers();
		model.addAttribute("USERS", blogs);
		return "welcome";
	}
}
