package shah.MockAShop.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@SequenceGenerator(name = "seq", initialValue = 4000, allocationSize = 1)
public class Cart {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
  private int cart_id;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "cust_id")
  private Customer customer;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "cart_items", 
      joinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "cart_id"), 
      inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id"))

      @JsonIgnore
  private Set<Product> products;

}
