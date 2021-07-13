package shah.MockAShop.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name="seq", initialValue=4000, allocationSize=1)
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  private int cart_id;
  
  @ManyToOne
  @JoinColumn(name = "cust_id")
  private Customer customer;
     
}
