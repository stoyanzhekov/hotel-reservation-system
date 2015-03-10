package bg.hotel.controller;

import bg.hotel.dto.PeriodDto;
import bg.hotel.dto.ReceptionReportModel;
import bg.hotel.entities.ReservationDetails;
import bg.hotel.entities.Room;
import bg.hotel.exception.InvalidPeriodException;
import bg.hotel.services.ReceptionService;

import org.springframework.context.annotation.Scope;

import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Scope("session")
@Named(value="receptionMB")
public class ReceptionController extends BaseController{

    @Inject
    private ReceptionService receptionService;
    
	private PeriodDto period = new PeriodDto();
	private ReceptionReportModel rrm ;
    

    public void showReport(PeriodDto period) {
    	try {
			rrm = receptionService.showReport(period);
		} catch (InvalidPeriodException e) {
			rrm.getDays().clear();
			rrm.getRooms().clear();
			addMessage(FacesMessage.SEVERITY_WARN, INFO_TITLE, INCORRECT_REPORTED_DATES_INPUT);
		}
    }

    public PeriodDto getPeriod() {
        return period;
    }
    
    public boolean isFree(Room room, String day) {
        Date date = getDateFromString(day);
        for (ReservationDetails rd : room.getReservationDetail()) {
             if (rd.getCheckIn().getTime() <= date.getTime() &&
                     rd.getCheckOut().getTime() > date.getTime()) {
                 return false;
             }
        }
        return true;
    }

    private Date getDateFromString(String day) {
        DateFormat format = new SimpleDateFormat("d/M/y");
        Date date = null;
        try {
            date = format.parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

	public ReceptionReportModel getRrm() {
		return rrm;
	}

	public void setRrm(ReceptionReportModel rrm) {
		this.rrm = rrm;
	}
    
}
