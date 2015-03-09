/**
 * 
 */
package bg.hotel.services;

import java.util.List;

import bg.hotel.dto.ReservationDetailsDto;
import bg.hotel.entities.Customer;
import bg.hotel.entities.Room;

public interface CustomerService {

	List<Customer> findAllCustomers();
	boolean book(ReservationDetailsDto res);
	List<Room> availableRoom(ReservationDetailsDto reservationDetails);
}
