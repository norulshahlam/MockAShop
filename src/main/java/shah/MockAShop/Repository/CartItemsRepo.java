package shah.MockAShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shah.MockAShop.Models.CartItems;

@Repository
public interface CartItemsRepo extends JpaRepository<CartItems, Integer> {
}

