package bg.hotel.services;

import bg.hotel.entities.Room;

import java.util.List;

public interface ReceptionService {
     List<Room> fetchAllRooms();
}
