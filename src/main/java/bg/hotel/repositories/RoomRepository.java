package bg.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bg.hotel.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long>, RoomRepositoryCustom{

	List<Room> findByNumber(Integer number);
	Room findById(Long id);
}
