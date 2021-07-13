package shah.MockAShop.Models;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
@Entity
@Data
@SequenceGenerator(name="seq", initialValue=3000, allocationSize=1)
public class Product {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  private int product_id;

  @NotNull(message = "Name cannot be blank")
  @Size(min=5, message = "Name must contain atleast 5 character")
  private String product_name;

  @NotNull(message = "Price cannot be blank")
  private BigDecimal product_price;

  @Size(min=5, message = "Description must contain atleast 8 character")
  @NotNull(message = "Description cannot be blank")
  private String product_description;

  @ManyToOne
  @JoinColumn(name = "seller_id")
  private Seller seller;
     
}
