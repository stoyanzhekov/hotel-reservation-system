/**
 * 
 */
package bg.hotel.services.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import bg.hotel.entities.Customer;
import bg.hotel.repositories.CustomerRepository;
import bg.hotel.services.CustomerService;

@Named
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

}
