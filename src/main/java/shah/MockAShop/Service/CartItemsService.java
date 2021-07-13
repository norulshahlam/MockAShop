package shah.MockAShop.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import shah.MockAShop.Models.CartItems;
import shah.MockAShop.Repository.CartItemsRepo;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class CartItemsService {

  @Autowired
  private CartItemsRepo cartItemsRepo;

  // FIND ALL
  public ResponseEntity<List<CartItems>> getCartItems() {
    System.out.println(33333);
    List<CartItems> findAll = cartItemsRepo.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(findAll);
  }
 
  // FIND ONE
  public ResponseEntity<?> getCartItemsById(int id) {
    CartItems result = new CartItems();
    try {
      result = cartItemsRepo.findById(id).get();
    } catch (Exception e) {
      result.setDummy_id(id);
      return createSimpleJSONResponse(HttpStatus.NOT_FOUND, "Resource not found");
    }
    return ResponseEntity.ok(result);
  }

  // ADD ONE
  public ResponseEntity<String> addCartItems(CartItems c, BindingResult result) {
    boolean ifExists = cartItemsRepo.existsById(c.getDummy_id());
    if (ifExists)
      return createSimpleJSONResponse(BAD_REQUEST, "Resource exists");
    if (result.hasErrors()) {
      System.out.println(result);
      return createSimpleJSONResponse(BAD_REQUEST, result.getFieldError().getDefaultMessage());
      }
    try {
      cartItemsRepo.save(c);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return createSimpleJSONResponse(BAD_REQUEST, e.getLocalizedMessage());
    }
    return createSimpleJSONResponse(CREATED, "Resource created");
  }

  // UPDATE ONE
  public ResponseEntity<String> updateCartItems(CartItems c) {
    boolean ifExists = cartItemsRepo.existsById(c.getDummy_id());
  
    if (!ifExists)
      return createSimpleJSONResponse(BAD_REQUEST, "Resource doesnt exists");
    try {
      cartItemsRepo.save(c);
    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
      return createSimpleJSONResponse(BAD_REQUEST, e.getLocalizedMessage());
    }
    return createSimpleJSONResponse(OK, "Resource updated");
  }

  // DELETE ONE
  public ResponseEntity<String> deleteCartItems(int c) {

    try {
      cartItemsRepo.deleteById(c);
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
