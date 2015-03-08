/**
 * 
 */
package bg.hotel.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.springframework.context.annotation.Scope;

import bg.hotel.dto.ReservationDetailsDto;
import bg.hotel.services.CustomerService;

@Scope("session")
@Named(value="customerMB")
public class CustomerController {
	
	@Inject
	private CustomerService customerService;
	
	private ReservationDetailsDto reservationDetails = new ReservationDetailsDto();
	
	public String onFlowProcess(FlowEvent event) {
		return event.getNewStep();
    }
	
	public void book(ReservationDetailsDto reservationDetails){
		customerService.book(reservationDetails.convertToEntity());
	}

	public ReservationDetailsDto getReservationDetails() {
		return reservationDetails;
	}

	public void setReservationDetails(ReservationDetailsDto reservationDetails) {
		this.reservationDetails = reservationDetails;
	}
}
