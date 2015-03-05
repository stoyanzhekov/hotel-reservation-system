/**
 * 
 */
package bg.hotel.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import bg.hotel.services.CustomerService;

@Scope("session")
@Named(value="customerMB")
public class CustomerController {

	private String allCustomerCount;
	
	@Inject
	private CustomerService customerService;

	public String getAllCustomerCount() {
		return customerService.findAllCustomers().size() + "";
	}

	public void setAllCustomerCount(String allCustomerCount) {
		this.allCustomerCount = allCustomerCount;
	}
}
