package bg.hotel.services;

import java.util.List;

import bg.hotel.entities.PricePeriod;
import bg.hotel.entities.Room;
import bg.hotel.exception.SavePricePeriodException;
import bg.hotel.exception.SaveRoomException;

public interface AdminService {
	
	Room saveRoom(Room room) throws SaveRoomException;
	
	void deleteRoom(Room room);
	
	List<Room> fetchAllRooms();
	
	Room findRoomById(Long id);

	PricePeriod savePricePeriod(PricePeriod pricePeriod) throws SavePricePeriodException;

	List<PricePeriod> fetchAllPricePeriods();
	
	void deletePricePeriod(PricePeriod pricePeriod);
}
