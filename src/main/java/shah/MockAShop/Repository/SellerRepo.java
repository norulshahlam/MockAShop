package shah.MockAShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shah.MockAShop.Models.Seller;

@Repository
public interface SellerRepo extends JpaRepository<Seller, Integer> {
}
