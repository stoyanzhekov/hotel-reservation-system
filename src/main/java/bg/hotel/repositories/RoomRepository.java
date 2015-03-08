package bg.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bg.hotel.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

	@SuppressWarnings("unchecked")
	Room saveAndFlush(Room room);
	List<Room> findByNumber(Integer number);
	List<Room> findAll();
	Room findById(Long id);
}
