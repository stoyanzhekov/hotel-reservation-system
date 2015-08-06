package bg.hotel.services.impl;

import bg.hotel.dto.PeriodDto;
import bg.hotel.entities.ReservationDetails;
import bg.hotel.entities.Room;
import bg.hotel.exception.InvalidPeriodException;
import bg.hotel.repositories.RoomRepository;
import bg.hotel.services.ReceptionService;
import bg.hotel.util.DateUtils;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Named(value="receptionService")
@Transactional(value=TxType.SUPPORTS)
public class ReceptionServiceImpl implements ReceptionService{

    private final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
    @Autowired
    private ApplicationContext applicationContext;
    
    @Inject
    private RoomRepository roomRepository;
    private ReceptionService receptionService;
    
    @PostConstruct
    private void init() {
    	receptionService = applicationContext.getBean(ReceptionService.class);
    }
    
    @Override
    public List<Room> fetchAllRooms() {
        return roomRepository.findAll();
    }
    
    @Override
    @Transactional(value=TxType.REQUIRED)
    public Map<Integer, Map<Date, Boolean>> showReport(PeriodDto period) throws InvalidPeriodException{
    	if(!DateUtils.isPeriodValid(period.getFrom(), period.getTo())){
    		throw new InvalidPeriodException();
    	}
    	Map<Integer, Map<Date, Boolean>> rrm = new HashMap<>();
    	List<Room> rooms = receptionService.fetchAllRooms();
    	for (Room room : rooms) {
    		rrm.put(room.getNumber(), populateReportedDays(room, period));
		}
    	return rrm;
    }
    
    private Map<Date, Boolean> populateReportedDays(Room room, PeriodDto period){
    	Map<Date, Boolean> result = new LinkedHashMap<>();
    	//calculate all days
    	int diffInDays = (int) ((period.getTo().getTime() - period.getFrom().getTime())/ DAY_IN_MILLIS );
        Date date = period.getFrom();
        result.put(date, isFree(room, date));
        for (int i = 1; i <= diffInDays; i++) {
            date = addOneDay(date);
            result.put(date, isFree(room, date));
        }
    	return result;
    }
    
    private boolean isFree(Room room, Date date) {
    	List<ReservationDetails> rdl = room.getReservationDetail();
        for (ReservationDetails rd : rdl) {
             if (rd.getCheckIn().getTime() <= date.getTime() &&
                     rd.getCheckOut().getTime() > date.getTime()) {
                 return false;
             }
        }
        return true;
    }
    
    private Date addOneDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        return date;
    }
}
