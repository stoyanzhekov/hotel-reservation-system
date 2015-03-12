/**
 * 
 */
package bg.hotel.services;

import bg.hotel.dto.ReservationDetailsDto;
import bg.hotel.entities.Customer;
import bg.hotel.entities.Room;
import bg.hotel.exception.InvalidPeriodException;

import java.util.List;

public interface CustomerService {

	List<Customer> findAllCustomers();
	boolean book(ReservationDetailsDto res) throws InvalidPeriodException;
	List<Room> availableRooms(ReservationDetailsDto reservationDetails);
}
