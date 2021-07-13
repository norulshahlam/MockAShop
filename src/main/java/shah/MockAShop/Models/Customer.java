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
@SequenceGenerator(name = "seq", initialValue = 1000, allocationSize = 1)
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  private int customer_id;

  @Size(min = 5, message = "Contact must contain atleast 8 character")
  @NotNull(message = "Contact cannot be blank")
  private String customer_contact;

  @NotNull(message = "Email cannot be blank")
  @Email(message = "Enter valid email")
  @Size(min = 5, message = "Email must contain atleast 5 character")
  private String customer_email;

  @NotNull(message = "Name cannot be blank")
  @Size(min = 5, message = "Name must contain atleast 5 character")
  private String customer_name;

  @Size(min = 5, message = "Password must contain atleast 8 character")
  @NotNull(message = "Password cannot be blank")
  private String customer_pswd;

  @NotNull(message = "Wallet cannot be blank")
  private BigDecimal customer_wallet;
  @JsonIgnore
  @OneToMany(mappedBy = "customer")
  private Set<Cart> cart;

}
