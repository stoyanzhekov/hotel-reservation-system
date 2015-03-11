package bg.hotel.repositories;

import bg.hotel.entities.PricePeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PricePeriodRepository extends JpaRepository<PricePeriod, Long>{
	@Query("select pricePeriod from PricePeriod pricePeriod where pricePeriod.room.number = ?1")
	List<PricePeriod> findAllByRoomNumber(Integer number);

    @Query(value = "select pricePeriod.* from price_period pricePeriod where (pricePeriod.from_date <= ?1 and pricePeriod.to_date >= ?1)" + //2 i 6
            "or (pricePeriod.from_date >= ?1 and pricePeriod.from_date <= ?2)" + //1
            "or (pricePeriod.from_date = ?1 and pricePeriod.to_date = ?2)", nativeQuery = true)
    List<PricePeriod> checkPricePeriod(Date from, Date to);
}

