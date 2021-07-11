package shah.MockAShop.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {

  @Id
  private String seller_id;
  private String seller_name;
  private String seller_email;
  private String seller_pswd;
  private String seller_contact;
     
}
