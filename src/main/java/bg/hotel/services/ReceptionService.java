package bg.hotel.services;

import bg.hotel.controller.PeriodDto;
import bg.hotel.dto.ReceptionReportModel;
import bg.hotel.entities.Room;
import bg.hotel.exception.ReportException;

import java.util.List;

public interface ReceptionService {
    List<Room> fetchAllRooms();

	ReceptionReportModel showReport(PeriodDto period) throws ReportException;
}
