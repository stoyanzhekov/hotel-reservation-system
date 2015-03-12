/**
 * 
 */
package bg.hotel.services.impl;

import bg.hotel.dto.ReservationDetailsDto;
import bg.hotel.entities.Address;
import bg.hotel.entities.Customer;
import bg.hotel.entities.Extras;
import bg.hotel.entities.Reservation;
import bg.hotel.entities.ReservationDetails;
import bg.hotel.entities.Room;
import bg.hotel.exception.InvalidPeriodException;
import bg.hotel.repositories.CustomerRepository;
import bg.hotel.repositories.ReservationRepository;
import bg.hotel.repositories.RoomRepository;
import bg.hotel.services.CustomerService;

import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.domain.Specification;

import bg.hotel.util.DateUtils;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
	public synchronized boolean book(ReservationDetailsDto reservationDetails) throws InvalidPeriodException {
		boolean result = true;
		if(!DateUtils.isPeriodValid(reservationDetails.getCheckIn(), reservationDetails.getCheckOut())){
			throw new InvalidPeriodException();
		}
		List<Room> availableRooms = customerService.availableRooms(reservationDetails);
		if(availableRooms.size() < reservationDetails.getRoomCount()){
			result = false;
		} else {
			reservationRepository.save(reservationDetailsDtoToEntity(reservationDetails, availableRooms));
		}

		return result;
	}

	@Override
	public List<Room> availableRooms(final ReservationDetailsDto reservationDetails) {
        Specification<Room> specification = new Specification<Room>() {

            @Override
            public Predicate toPredicate(Root<Room> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                Boolean airConditioning = reservationDetails.getAirConditioning();
                if (airConditioning) {
                    Expression<Long> expression = root.get("extras").get("airConditioning");
                    predicates.add(criteriaBuilder.equal(expression, airConditioning));
                }
                Boolean bathTub = reservationDetails.getBathtub();
                if (bathTub) {
                    Expression<Long> expression = root.get("extras").get("bathtub");
                    predicates.add(criteriaBuilder.equal(expression, bathTub));
                }
                Boolean kitchen = reservationDetails.getKitchen();
                if (kitchen) {
                    Expression<Long> expression = root.get("extras").get("kitchen");
                    predicates.add(criteriaBuilder.equal(expression, kitchen));
                }
                Boolean laundry = reservationDetails.getLaundry();
                if (kitchen) {
                    Expression<Long> expression = root.get("extras").get("laundry");
                    predicates.add(criteriaBuilder.equal(expression, laundry));
                }
                Boolean terrace = reservationDetails.getTerrace();
                if (terrace) {
                    Expression<Long> expression = root.get("extras").get("terrace");
                    predicates.add(criteriaBuilder.equal(expression, terrace));
                }
                Boolean tv = reservationDetails.getTv();
                if (tv) {
                    Expression<Long> expression = root.get("extras").get("tv");
                    predicates.add(criteriaBuilder.equal(expression, tv));
                }
                criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        };
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
    	boolean result = true;
    	Interval new_, existing;
    	List<ReservationDetails> rds = room.getReservationDetail();
        for (ReservationDetails rd : rds) {
        	new_ = new Interval(reservationDetails.getCheckIn().getTime(), reservationDetails.getCheckOut().getTime());
        	existing = new Interval(rd.getCheckIn().getTime(), rd.getCheckOut().getTime());
        	boolean overlap = new_.overlaps(existing);
        	boolean abuts = new_.abuts(existing);
        	if(overlap || abuts){
        		result = false;
        		break;
        	}
        	
        }
        return result;
    }

    private Reservation reservationDetailsDtoToEntity(ReservationDetailsDto reservationDetails, List<Room> availableRooms) {
		Reservation reservation = new Reservation();
		reservation.setCreatedAt(new Date());
		Customer customer = new Customer();
		customer.setFirstName(reservationDetails.getFirstName());
		customer.setLastName(reservationDetails.getLastName());
		//customer.setReservation(reservation);
		reservation.setCustomer(customer);
		Address address = new Address();
		address.setStreetName(reservationDetails.getStreetName());
		address.setStreetNumber(reservationDetails.getStreetNumber());
		address.setPostCode(reservationDetails.getPostCode());
		ArrayList<ReservationDetails> rds = new ArrayList<>();
		reservation.setReservationDetails(rds);
		customer.setAddress(address);
		for(int i = 0; reservationDetails.getRoomCount() > i; i++){
			ReservationDetails rd = new ReservationDetails();
			rd.setCheckIn(reservationDetails.getCheckIn());
			rd.setCheckOut(reservationDetails.getCheckOut());
			rd.setReservation(reservation);
			Extras extras = new Extras();
			extras.setAirConditioning(reservationDetails.getAirConditioning());
			extras.setBathtub(reservationDetails.getBathtub());
			extras.setKitchen(reservationDetails.getKitchen());
			extras.setLaundry(reservationDetails.getLaundry());
			extras.setTerrace(reservationDetails.getTerrace());
			extras.setTv(reservationDetails.getTv());
			Room room = availableRooms.get(i);
			room.setExtras(extras);
			extras.setRoom(room);
			rd.setRoom(room);
			rds.add(rd);
		}
		return reservation;
	}
}
