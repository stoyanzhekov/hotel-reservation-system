package bg.hotel.repositories;

import java.util.List;

import bg.hotel.entities.Room;

public interface RoomRepositoryCustom {

	List<Room> findAvailableRooms();
}
