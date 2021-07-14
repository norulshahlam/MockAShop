package shah.MockAShop.Models;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name="seq2", initialValue=2000, allocationSize=1)
public class Seller  { 

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq2")
  private int seller_id;
 
  @NotNull(message = "Name cannot be blank")
  @Size(min=5, message = "Name must contain atleast 5 character")
  private String seller_name;

  @NotNull(message = "Email cannot be blank")
  @Email(message = "Enter valid email")
  @Size(min=5, message = "Email must contain atleast 5 character")
  private String seller_email;
 
  @Size(min=5, message = "Password must contain atleast 8 character")
  @NotNull(message = "Password cannot be blank")
  private String seller_pswd;

  @Size(min=5, message = "Contact must contain atleast 8 character")
  @NotNull(message = "Password cannot be blank")
  private String seller_contact;

  @NotNull(message = "Wallet cannot be blank")
  private BigDecimal seller_wallet;
  @JsonIgnore
  @OneToMany(mappedBy = "seller")
  private Set<Product> product;
     
}
