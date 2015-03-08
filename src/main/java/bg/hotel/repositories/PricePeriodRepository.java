package bg.hotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bg.hotel.entities.PricePeriod;

public interface PricePeriodRepository extends JpaRepository<PricePeriod, Long>{
	@Query("select pricePeriod from PricePeriod pricePeriod where pricePeriod.room.number = ?1)")
	List<PricePeriod> findAllByRoomNumber(Integer number);
}
