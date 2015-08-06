/**
 * 
 */
package bg.hotel.controller;

import bg.hotel.dto.ReservationDetailsDto;
import bg.hotel.entities.RoomType;
import bg.hotel.exception.InvalidPeriodException;
import bg.hotel.services.CustomerService;
import bg.hotel.services.MailingService;

import org.springframework.context.annotation.Scope;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

@Scope("session")
@Named(value="customerMB")
public class CustomerController extends BaseController{
	
	@Inject
	private CustomerService customerService;
	
	@Inject
	private MailingService mailingService;
	
	private ReservationDetailsDto reservationDetails = new ReservationDetailsDto();
	
	public void book(ReservationDetailsDto reservationDetails){
		try {
			boolean bookSucceed = customerService.book(reservationDetails);
			if(bookSucceed){
				mailingService.bookingConformation(reservationDetails.getEmail(), RESERVATION_SUCCEED);
			} else {
				mailingService.bookingConformation(reservationDetails.getEmail(), RESERVATION_NOT_SUCCEED);
			}
			addMessage(FacesMessage.SEVERITY_WARN, INFO_TITLE, RESERVATION_MAILING_MSG);
		} catch (InvalidPeriodException e) {
			addMessage(FacesMessage.SEVERITY_WARN, INFO_TITLE, INCORRECT_REPORTED_DATES_INPUT);
		}
		
	}

	public ReservationDetailsDto getReservationDetails() {
		return reservationDetails;
	}

	public void setReservationDetails(ReservationDetailsDto reservationDetails) {
		this.reservationDetails = reservationDetails;
	}
	
	public RoomType[] getRoomTypes() {
        return RoomType.values();
    }
}
