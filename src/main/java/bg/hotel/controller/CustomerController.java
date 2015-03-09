/**
 * 
 */
package bg.hotel.controller;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import bg.hotel.dto.ReservationDetailsDto;
import bg.hotel.services.CustomerService;

@Scope("session")
@Named(value="customerMB")
public class CustomerController {
	
	private static final String INFO_TITLE = "Info";
	private static final String RESERVATION_SUCCEED = "Reservation is successfully done.";
	private static final String RESERVATION_NOT_SUCCEED = "There is not available rooms for this period";
	
	@Inject
	private CustomerService customerService;
	
	private ReservationDetailsDto reservationDetails = new ReservationDetailsDto();
	
	public void book(ReservationDetailsDto reservationDetails){
		if(customerService.book(reservationDetails)){
			addMessage(FacesMessage.SEVERITY_INFO, INFO_TITLE, RESERVATION_NOT_SUCCEED);
		} else {
			addMessage(FacesMessage.SEVERITY_INFO, INFO_TITLE, RESERVATION_SUCCEED);
		}
	}

	public ReservationDetailsDto getReservationDetails() {
		return reservationDetails;
	}

	public void setReservationDetails(ReservationDetailsDto reservationDetails) {
		this.reservationDetails = reservationDetails;
	}
	
	private void addMessage(Severity severity, String summary, String details) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, details));
	}
}
