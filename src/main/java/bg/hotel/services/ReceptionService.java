package bg.hotel.services;

import bg.hotel.dto.PeriodDto;
import bg.hotel.entities.Room;
import bg.hotel.exception.InvalidPeriodException;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ReceptionService {
    List<Room> fetchAllRooms();

	Map<Integer, Map<Date, Boolean>> showReport(PeriodDto period) throws InvalidPeriodException;
}
