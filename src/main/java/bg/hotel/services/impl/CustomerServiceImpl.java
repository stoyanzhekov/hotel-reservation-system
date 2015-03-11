/**
 * 
 */
package bg.hotel.services.impl;

import bg.hotel.dto.ReservationDetailsDto;
import bg.hotel.entities.Customer;
import bg.hotel.entities.Reservation;
import bg.hotel.entities.ReservationDetails;
import bg.hotel.entities.Room;
import bg.hotel.repositories.CustomerRepository;
import bg.hotel.repositories.ReservationRepository;
import bg.hotel.repositories.RoomRepository;
import bg.hotel.repositories.RoomSpecification;
import bg.hotel.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.domain.Specification;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        Specification<Room> specification = RoomSpecification.create(reservationDetails);
        List<Room> allRooms = roomRepository.findAll(specification);
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : allRooms) {
            if (isRoomFree(room, reservationDetails)) {
                availableRooms.add(room);
            }
        }
		return availableRooms;
	}

    private Boolean isRoomFree(Room room, ReservationDetailsDto reservationDetails) {
        //TODO watch some youtube architectural videos, research a lot, implement the best practices,
        // plan some refactoring and do it in the SQL
        for (ReservationDetails rd : room.getReservationDetail()) {
            if ((reservationDetails.getCheckIn().getTime() <= rd.getCheckIn().getTime()) &&
                    (reservationDetails.getCheckOut().getTime() >= rd.getCheckIn().getTime())){
                return false;
            }
            if ((reservationDetails.getCheckIn().getTime() >= rd.getCheckIn().getTime()) &&
                    (reservationDetails.getCheckIn().getTime() <= rd.getCheckOut().getTime())){
                return false;
            }
            if ((reservationDetails.getCheckIn().getTime() == rd.getCheckIn().getTime()) &&
                    (reservationDetails.getCheckOut().getTime() == rd.getCheckOut().getTime())){
                return false;
            }
        }
        return true;
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
