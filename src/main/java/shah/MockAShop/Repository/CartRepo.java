package shah.MockAShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shah.MockAShop.Models.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
}

