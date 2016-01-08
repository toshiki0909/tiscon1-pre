package tiscon1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tiscon1.model.Customer;

/**
 * @author kawasima
 */
@Repository
public interface CustomerRepository extends JpaSpecificationExecutor<Customer>, JpaRepository<Customer, Long> {
}
