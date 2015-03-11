package bg.hotel.services;

import bg.hotel.dto.PeriodDto;
import bg.hotel.dto.ReceptionReportModel;
import bg.hotel.entities.Room;
import bg.hotel.exception.InvalidPeriodException;

import java.util.List;

public interface ReceptionService {
    List<Room> fetchAllRooms();

	ReceptionReportModel showReport(PeriodDto period) throws InvalidPeriodException;
}
