package shah.MockAShop.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shah.MockAShop.Models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

  // @Query(value="select product_id, seller_id from product", nativeQuery=true)
  // List<Product> findAll();
}

