package bg.hotel.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bg.hotel.entities.PricePeriod;

public interface PricePeriodRepository extends JpaRepository<PricePeriod, Long>{

	@SuppressWarnings("unchecked")
	PricePeriod saveAndFlush(PricePeriod pricePeriod);
	List<PricePeriod> findByFromAndTo(Date from, Date to);
}
