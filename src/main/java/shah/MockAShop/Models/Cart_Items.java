package shah.MockAShop.Models;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cart_Items {
  @Id
  private int dummy_id;
  private int cart_id;
  private int product_id;
  private int quantity;
}
