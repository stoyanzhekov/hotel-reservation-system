package bg.hotel.repositories;

import bg.hotel.entities.PricePeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PricePeriodRepository extends JpaRepository<PricePeriod, Long>{

	@Query("select pricePeriod from PricePeriod pricePeriod left join fetch pricePeriod.room "
			+ "where pricePeriod.room.number = ?1 ")
    List<PricePeriod> checkPricePeriod(Integer id);
}

