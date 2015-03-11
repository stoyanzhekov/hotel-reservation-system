package bg.hotel.services.impl;

import bg.hotel.dto.PeriodDto;
import bg.hotel.dto.ReceptionReportModel;
import bg.hotel.entities.ReservationDetails;
import bg.hotel.entities.Room;
import bg.hotel.exception.InvalidPeriodException;
import bg.hotel.repositories.RoomRepository;
import bg.hotel.services.CustomerService;
import bg.hotel.services.ReceptionService;
import bg.hotel.util.DateUtils;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Named(value="receptionService")
@Transactional(value=TxType.SUPPORTS)
public class ReceptionServiceImpl implements ReceptionService{

	private DateFormat df = new SimpleDateFormat("d/M/y");
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
        return getDummyData();
        //return roomRepository.findAll();
    }
    
    @Override
    public ReceptionReportModel showReport(PeriodDto period) throws InvalidPeriodException{
    	if(!DateUtils.isPeriodValid(period.getFrom(), period.getTo())){
    		throw new InvalidPeriodException();
    	}
    	ReceptionReportModel rrm = new ReceptionReportModel();
    	rrm.setDays(populateReportedDays(period));
    	rrm.setRooms(receptionService.fetchAllRooms());
    	return rrm;
    }
    
    private List<String> populateReportedDays(PeriodDto period){
    	ArrayList<String> arr = new ArrayList<>();
    	int diffInDays = (int) ((period.getTo().getTime() - period.getFrom().getTime())/ DAY_IN_MILLIS );
        Date dateToAdd = period.getFrom();
        addDateToArray(arr, dateToAdd);
        for (int i = 1; i <= diffInDays; i++) {
            dateToAdd = addOneDay(dateToAdd);
            addDateToArray(arr, dateToAdd);
        }
    	return arr;
    }
    
    private void addDateToArray(List<String> arr, Date dateToAdd) {
        String date = df.format(dateToAdd);
        arr.add(date);
    }
    
    private Date addOneDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        return date;
    }

    public List<Room> getDummyData() {
        List<Room> roomList = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            roomList.add(getRoom(i));
        }
        return roomList;
    }

    public Room getRoom(int roomNumber) {
        Room room = new Room();
        room.setNumber(roomNumber);
        room.setReservationDetail(getReservationDetails());
        return room;
    }

    public List<ReservationDetails> getReservationDetails() {
        List<ReservationDetails> reservationDetails = new ArrayList<>();

        ReservationDetails rd = new ReservationDetails();

        Calendar calFrom = Calendar.getInstance();
        Random randomGenerator = new Random();
        Integer numberFrom = randomGenerator.nextInt(29);
        Integer numberTo = randomGenerator.nextInt(29);
        if (numberFrom > numberTo) {
            Integer random;
            random = numberFrom;
            numberFrom = numberTo;
            numberTo = random;
        }
        calFrom.add(Calendar.DATE, numberFrom);

        Calendar calTo = Calendar.getInstance();
        calTo.add(Calendar.DATE, numberTo);

        rd.setCheckIn(calFrom.getTime());
        rd.setCheckOut(calTo.getTime());

        reservationDetails.add(rd);

        return reservationDetails;
    }
}
