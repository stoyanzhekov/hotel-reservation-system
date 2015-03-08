/**
 * 
 */
package bg.hotel.services;

import java.util.List;

import bg.hotel.entities.Customer;
import bg.hotel.entities.Reservation;

public interface CustomerService {

	List<Customer> findAllCustomers();
	void book(Reservation res);

}
