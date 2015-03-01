/**
 * 
 */
package bg.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import bg.hotel.entities.Customer;
import bg.hotel.services.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/welcome")
	public String welcome(Model model) {
		List<Customer> customers = customerService.findAllCustomers();
		model.addAttribute("Customers", customers);
		return "welcome";
	}
}
