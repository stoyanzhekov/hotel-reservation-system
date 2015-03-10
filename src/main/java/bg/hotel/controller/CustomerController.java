/**
 * 
 */
package bg.hotel.controller;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import bg.hotel.dto.ReservationDetailsDto;
import bg.hotel.exception.InvalidPeriodException;
import bg.hotel.services.CustomerService;

@Scope("session")
@Named(value="customerMB")
public class CustomerController extends BaseController{
	
	@Inject
	private CustomerService customerService;
	
	private ReservationDetailsDto reservationDetails = new ReservationDetailsDto();
	
	public void book(ReservationDetailsDto reservationDetails){
		try {
			if(customerService.book(reservationDetails)){
				addMessage(FacesMessage.SEVERITY_INFO, INFO_TITLE, RESERVATION_NOT_SUCCEED);
			} else {
				addMessage(FacesMessage.SEVERITY_INFO, INFO_TITLE, RESERVATION_SUCCEED);
			}
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
}
