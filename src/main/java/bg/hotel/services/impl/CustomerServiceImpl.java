/**
 * 
 */
package bg.hotel.services.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import bg.hotel.entities.Customer;
import bg.hotel.entities.Reservation;
import bg.hotel.repositories.CustomerRepository;
import bg.hotel.repositories.ReservationRepository;
import bg.hotel.services.CustomerService;

@Named
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;

	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void book(Reservation res) {
		reservationRepository.save(res);
	}

}
