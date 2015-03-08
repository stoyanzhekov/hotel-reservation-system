package bg.hotel.services;

import java.util.List;

import bg.hotel.entities.PricePeriod;
import bg.hotel.entities.Room;
import bg.hotel.exception.SavePricePeriodException;
import bg.hotel.exception.SaveRoomException;

public interface AdminService {
	
	Room save(Room room) throws SaveRoomException;
	
	List<Room> fetchAllRooms();
	
	Room findById(Long id);

	PricePeriod save(PricePeriod pricePeriod) throws SavePricePeriodException;

	List<PricePeriod> fetchAllPricePeriods();
}
