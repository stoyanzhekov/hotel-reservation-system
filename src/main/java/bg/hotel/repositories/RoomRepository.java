package bg.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bg.hotel.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

	Room saveAndFlush(Room room);
}
