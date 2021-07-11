package shah.MockAShop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import shah.MockAShop.Models.Customer;
import shah.MockAShop.Repository.CustomerRepo;

@Service
public class CustomerService {
  
  @Autowired
  private CustomerRepo customerRepo;

  public List<Customer> getCustomers() {
    List<Customer> findAll = customerRepo.findAll();
    return findAll;
  }

  public Customer getCustomerById(String id) {
    Customer result = customerRepo.findById(id).get();
    System.out.println("****************");
    System.out.println(result);
    return result;
  }

  public Customer addCustomer(Customer c) {
    Customer findOne = customerRepo.save(c);
    return findOne;
  }

	public Customer updateCustomer(Customer c) {
		Customer updated = customerRepo.save(c);
    return updated;
	}

  public void deleteCustomer(String c) {
    customerRepo.deleteById(c);
  }
}
