/**
 * 
 */
package bg.hotel.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import bg.hotel.dto.ReservationDetailsDto;
import bg.hotel.services.CustomerService;

@Scope("session")
@Named(value="customerMB")
public class CustomerController {
	
	@Inject
	private CustomerService customerService;
	
	private ReservationDetailsDto reservationDetails = new ReservationDetailsDto();
	
	public void book(){
		System.out.println("test");
		//customerService.book(reservationDetails.convertToEntity());
	}

	public ReservationDetailsDto getReservationDetails() {
		return reservationDetails;
	}

	public void setReservationDetails(ReservationDetailsDto reservationDetails) {
		this.reservationDetails = reservationDetails;
	}
}
