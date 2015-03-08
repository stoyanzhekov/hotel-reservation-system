package bg.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import bg.hotel.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
