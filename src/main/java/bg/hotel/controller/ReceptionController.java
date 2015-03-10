package bg.hotel.controller;

import bg.hotel.entities.ReservationDetails;
import bg.hotel.entities.Room;
import bg.hotel.services.ReceptionService;
import org.springframework.context.annotation.Scope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Scope("session")
@Named(value="receptionMB")
public class ReceptionController {

    @Inject
    private ReceptionService receptionService;

	private PeriodDto period = new PeriodDto();
    private List<Room> rooms = new ArrayList<>();
    private List<String> days = new ArrayList<>();
    private DateFormat df = new SimpleDateFormat("d/M/y");
    private final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

    public void initRooms() {
        if (rooms.isEmpty()) {
            rooms = receptionService.fetchAllRooms();
        }
    }

    public void calculateDays() {
        validateInput();
        clearDays();
        int diffInDays = (int) ((period.getTo().getTime() - period.getFrom().getTime())/ DAY_IN_MILLIS );
        Date dateToAdd = period.getFrom();
        addDateToArray(dateToAdd);
        for (int i = 1; i <= diffInDays; i++) {
            dateToAdd = addOneDay(dateToAdd);
            addDateToArray(dateToAdd);
        }
    }

    private void validateInput() {
        if (period.getFrom().after(period.getTo())) {
            FacesContext.getCurrentInstance().addMessage("newPassword", new FacesMessage("Error: Date 'From' is after Date 'To'. Please correct!"));
            return;
        }
    }

    private void addDateToArray(Date dateToAdd) {
        String date = df.format(dateToAdd);
        days.add(date);
    }

    private void clearDays() {
        days = new ArrayList<>();
    }

    public Date addOneDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        return date;
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

    public PeriodDto getPeriod() {
        return period;
    }

    public List<String> getDays() {
        return days;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
