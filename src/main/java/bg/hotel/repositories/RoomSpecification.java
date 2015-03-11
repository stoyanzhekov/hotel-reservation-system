package bg.hotel.repositories;

import bg.hotel.dto.ReservationDetailsDto;
import bg.hotel.entities.Room;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public final class RoomSpecification {

    private RoomSpecification() {
    }

    public static Specification<Room> create(final ReservationDetailsDto roomExtras) {

        return new Specification<Room>() {

            @Override
            public Predicate toPredicate(Root<Room> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<Predicate>();

                Boolean airConditioning = roomExtras.getAirConditioning();
                if (airConditioning) {
                    Expression<Long> expression = root.get("extras").get("airConditioning");
                    predicates.add(criteriaBuilder.equal(expression, airConditioning));
                }

                Boolean bathTub = roomExtras.getBathtub();
                if (bathTub) {
                    Expression<Long> expression = root.get("extras").get("bathtub");
                    predicates.add(criteriaBuilder.equal(expression, bathTub));
                }

                Boolean kitchen = roomExtras.getKitchen();
                if (kitchen) {
                    Expression<Long> expression = root.get("extras").get("kitchen");
                    predicates.add(criteriaBuilder.equal(expression, kitchen));
                }

                Boolean laundry = roomExtras.getLaundry();
                if (kitchen) {
                    Expression<Long> expression = root.get("extras").get("laundry");
                    predicates.add(criteriaBuilder.equal(expression, laundry));
                }

                Boolean terrace = roomExtras.getTerrace();
                if (terrace) {
                    Expression<Long> expression = root.get("extras").get("terrace");
                    predicates.add(criteriaBuilder.equal(expression, terrace));
                }

                Boolean tv = roomExtras.getTv();
                if (tv) {
                    Expression<Long> expression = root.get("extras").get("tv");
                    predicates.add(criteriaBuilder.equal(expression, tv));
                }

                criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        };
    }
}