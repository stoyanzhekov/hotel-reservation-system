/**
 * 
 */
package bg.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import bg.hotel.entities.Customer;

public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}
