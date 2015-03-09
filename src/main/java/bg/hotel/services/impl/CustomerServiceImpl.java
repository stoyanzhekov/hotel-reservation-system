/**
 * 
 */
package bg.hotel.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import bg.hotel.dto.ReservationDetailsDto;
import bg.hotel.entities.Customer;
import bg.hotel.entities.Reservation;
import bg.hotel.entities.ReservationDetails;
import bg.hotel.entities.Room;
import bg.hotel.repositories.CustomerRepository;
import bg.hotel.repositories.ReservationRepository;
import bg.hotel.repositories.RoomRepository;
import bg.hotel.services.CustomerService;

@Named
@Transactional(value=TxType.SUPPORTS)
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
    private ApplicationContext applicationContext;
	
	private CustomerService customerService;

	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}
	
	@PostConstruct
    private void init() {
		customerService = applicationContext.getBean(CustomerService.class);
    }

	@Override
	@Transactional(value=TxType.REQUIRED)
	public synchronized boolean book(ReservationDetailsDto reservationDetails) {
		boolean result = true;
		List<Room> availableRooms = customerService.availableRoom(reservationDetails);
		if(availableRooms.size() == 0 || availableRooms.size() < reservationDetails.getRoomCount()){
			result = false;
		} else {
			reservationRepository.save(reservationDetailsDtoToEntity(reservationDetails, availableRooms));
		}
		
		
		return result;
	}

	@Override
	public List<Room> availableRoom(ReservationDetailsDto reservationDetails) {
		// TODO Auto-generated method stub
		//date and extras
		return null;
	}


	private Reservation reservationDetailsDtoToEntity(ReservationDetailsDto reservationDetails, List<Room> availableRooms) {
		Reservation reservation = new Reservation();
		reservation.setCreatedAt(new Date());
		ArrayList<ReservationDetails> rds = new ArrayList<>();
		reservation.setReservationDetails(rds);
		for(int i = 0; availableRooms.size() > i; i++){
			ReservationDetails rd = new ReservationDetails();
			rd.setCheckIn(reservationDetails.getCheckIn());
			rd.setCheckOut(reservationDetails.getCheckOut());
			rd.setReservation(reservation);
			rd.setRoom(availableRooms.get(i));
			rds.add(rd);
		}
		return reservation;
	}
}
