package shah.MockAShop.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
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
    System.out.println(33333);
    List<Customer> findAll = customerRepo.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(findAll);
  }
 
  // FIND ONE
  public ResponseEntity<?> getCustomerById(int id) {
    Customer result = new Customer();
    try {
      result = customerRepo.findById(id).get();
    } catch (Exception e) {
      result.setCustomer_id(id);
      return createSimpleJSONResponse(HttpStatus.NOT_FOUND, "Resource not found");
    }
    return ResponseEntity.ok(result);
  }

  // ADD ONE
  public ResponseEntity<String> addCustomer(Customer c, BindingResult result) {
    boolean ifExists = customerRepo.existsById(c.getCustomer_id());
    if (ifExists)
      return createSimpleJSONResponse(BAD_REQUEST, "Resource exists");
    if (result.hasErrors()) {
      System.out.println(result);
      return createSimpleJSONResponse(BAD_REQUEST, result.getFieldError().getDefaultMessage());
      }
    try {
      customerRepo.save(c);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return createSimpleJSONResponse(BAD_REQUEST, e.getLocalizedMessage());
    }
    return createSimpleJSONResponse(CREATED, "Resource created");
  }

  // UPDATE ONE
  public ResponseEntity<String> updateCustomer(Customer c) {
    boolean ifExists = customerRepo.existsById(c.getCustomer_id());
  
    if (!ifExists)
      return createSimpleJSONResponse(BAD_REQUEST, "Resource doesnt exists");
    try {
      customerRepo.save(c);
    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
      return createSimpleJSONResponse(BAD_REQUEST, e.getLocalizedMessage());
    }
    return createSimpleJSONResponse(OK, "Resource updated");
  }

  // DELETE ONE
  public ResponseEntity<String> deleteCustomer(int c) {

    try {
      customerRepo.deleteById(c);
    } catch (Exception e) {
      return createSimpleJSONResponse(NOT_FOUND, c+" doesnt exists!");
    }
    return createSimpleJSONResponse(OK, "Item "+c+" deleted");
  }

  // CUSTOM RESPONSE WITH MESSAGE
  private ResponseEntity<String> createSimpleJSONResponse(HttpStatus status, String message) {
    return createJSONResponse(status, "{\"message\":\"" + message + "\"}");
  } 
 
  private ResponseEntity<String> createJSONResponse(HttpStatus status, String body) {
    return ResponseEntity.status(status).contentType(APPLICATION_JSON).body(body);
  }
}
