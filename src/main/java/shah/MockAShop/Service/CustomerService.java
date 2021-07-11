package shah.MockAShop.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import shah.MockAShop.Models.Customer;
import shah.MockAShop.Repository.CustomerRepo;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepo customerRepo;

  // FIND ALL
  public ResponseEntity<List<Customer>> getCustomers() {
    List<Customer> findAll = customerRepo.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(findAll);
  }

  // FIND ONE
  public ResponseEntity<Customer> getCustomerById(String id) {
    Customer result;
    try {
      result = customerRepo.findById(id).get();
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    System.out.println("****************");
    System.out.println(result);
    return ResponseEntity.ok(result);
  }

  // ADD ONE
  public ResponseEntity<String> addCustomer(Customer c) {
    try {
      customerRepo.save(c);
    } catch (Exception e) {
      return createSimpleJSONResponse(BAD_REQUEST,  e.getLocalizedMessage());
    }
    return createSimpleJSONResponse(CREATED, "Resource created");
  }

  // UPDATE ONE
  public ResponseEntity<String> updateCustomer(Customer c) {
    try {
      customerRepo.save(c);
    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
      return createSimpleJSONResponse(BAD_REQUEST, e.getLocalizedMessage());
    }
    return createSimpleJSONResponse(OK, "Resource updated");
  }

  // DELETE ONE
  public ResponseEntity<String> deleteCustomer(String c) {

    try {
      customerRepo.deleteById(c);
    } catch (Exception e) {
      return createSimpleJSONResponse(NOT_FOUND,  e.getLocalizedMessage());
    }
    return createSimpleJSONResponse(OK, "Resource deleted");
  }

  // CUSTOM RESPONSE WITH MESSAGE
  private ResponseEntity<String> createSimpleJSONResponse(HttpStatus status, String message) {
    return createJSONResponse(status, "{\"message\":\"" + message + "\"}");
  }

  private ResponseEntity<String> createJSONResponse(HttpStatus status, String body) {
    return ResponseEntity.status(status).contentType(APPLICATION_JSON).body(body);
  }
}
