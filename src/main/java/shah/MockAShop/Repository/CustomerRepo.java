package shah.MockAShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shah.MockAShop.Models.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {
  

}
