package shah.MockAShop.Models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name="seq", initialValue=1000, allocationSize=1000)
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  private String seller_id;

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
     
}
