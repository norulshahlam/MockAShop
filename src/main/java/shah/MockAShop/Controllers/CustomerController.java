package shah.MockAShop.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shah.MockAShop.Models.Customer;
import shah.MockAShop.Service.CustomerService;

@RestController
public class CustomerController {

  @Autowired
  CustomerService customerService;

  @GetMapping("/")
  public String index() {
    return "home page";
  }

  @GetMapping("/customers")
  public List<Customer> getCustomers() {
    return customerService.getCustomers();
  }

  @GetMapping("/customer/{id}")
  public Customer getCustomerById(@PathVariable("id") String id) {
   return customerService.getCustomerById(id);
  }

  @PostMapping("/customer")
  public Customer addCustomer(@RequestBody Customer c) {
    return customerService.addCustomer(c);
  }
  @PutMapping("/customer")
  public Customer updateCustomer(@RequestBody Customer c) {
    return customerService.updateCustomer(c);
  }

  @DeleteMapping("/customer/{id}")
  public void deleteCustomer(@PathVariable("id") String id) {
    customerService.deleteCustomer(id);
  }
}

