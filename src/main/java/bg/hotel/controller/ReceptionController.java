package bg.hotel.controller;

import bg.hotel.dto.PeriodDto;
import bg.hotel.exception.InvalidPeriodException;
import bg.hotel.services.ReceptionService;

import org.springframework.context.annotation.Scope;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.Map;

@Scope("request")
@Named(value="receptionMB")
public class ReceptionController extends BaseController{

    @Inject
    private ReceptionService receptionService;
    
	private PeriodDto period = new PeriodDto();
	private Map<Integer, Map<Date, Boolean>> rrm = null;
	
    public void showReport(PeriodDto period) {
    	try {
			rrm = receptionService.showReport(period);
		} catch (InvalidPeriodException e) {
			rrm.clear();
			addMessage(FacesMessage.SEVERITY_WARN, INFO_TITLE, INCORRECT_REPORTED_DATES_INPUT);
		}
    }

    public PeriodDto getPeriod() {
        return period;
    }

	public Map<Integer, Map<Date, Boolean>> getRrm() {
		return rrm;
	}

	public void setRrm(Map<Integer, Map<Date, Boolean>> rrm) {
		this.rrm = rrm;
	}
    
}
