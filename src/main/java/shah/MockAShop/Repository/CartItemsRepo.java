package shah.MockAShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shah.MockAShop.Models.Cart_Items;

@Repository
public interface CartItemsRepo extends JpaRepository<Cart_Items, Integer> {
}

