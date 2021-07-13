package shah.MockAShop.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import shah.MockAShop.Models.Cart;
import shah.MockAShop.Repository.CartRepo;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class CartService {

  @Autowired
  private CartRepo cartRepo;

  // FIND ALL
  public ResponseEntity<List<Cart>> getCarts() {
    System.out.println(33333);
    List<Cart> findAll = cartRepo.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(findAll);
  }
 
  // FIND ONE
  public ResponseEntity<?> getCartById(int id) {
    Cart result = new Cart();
    try {
      result = cartRepo.findById(id).get();
    } catch (Exception e) {
      result.setCart_id(id);
      return createSimpleJSONResponse(HttpStatus.NOT_FOUND, "Resource not found");
    }
    return ResponseEntity.ok(result);
  }

  // ADD ONE
  public ResponseEntity<String> addCart(Cart c, BindingResult result) {
    boolean ifExists = cartRepo.existsById(c.getCart_id());
    if (ifExists)
      return createSimpleJSONResponse(BAD_REQUEST, "Resource exists");
    if (result.hasErrors()) {
      System.out.println(result);
      return createSimpleJSONResponse(BAD_REQUEST, result.getFieldError().getDefaultMessage());
      }
    try {
      cartRepo.save(c);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return createSimpleJSONResponse(BAD_REQUEST, e.getLocalizedMessage());
    }
    return createSimpleJSONResponse(CREATED, "Resource created");
  }

  // UPDATE ONE
  public ResponseEntity<String> updateCart(Cart c) {
    boolean ifExists = cartRepo.existsById(c.getCart_id());
  
    if (!ifExists)
      return createSimpleJSONResponse(BAD_REQUEST, "Resource doesnt exists");
    try {
      cartRepo.save(c);
    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
      return createSimpleJSONResponse(BAD_REQUEST, e.getLocalizedMessage());
    }
    return createSimpleJSONResponse(OK, "Resource updated");
  }

  // DELETE ONE
  public ResponseEntity<String> deleteCart(int c) {

    try {
      cartRepo.deleteById(c);
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
