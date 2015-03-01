/**
 * 
 */
package bg.hotel.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.hotel.entities.Customer;
import bg.hotel.repositories.CustomerRepository;
import bg.hotel.services.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

}
