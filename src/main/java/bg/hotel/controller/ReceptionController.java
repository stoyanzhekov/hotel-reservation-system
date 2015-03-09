package bg.hotel.controller;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Scope("session")
@Named(value="receptionMB")
public class ReceptionController {

	private PeriodDto Period = new PeriodDto();

	public PeriodDto getPeriod() {
		return Period;
	}

	public void setPeriod(PeriodDto period) {
		Period = period;
	}
	
}
