package shah.MockAShop.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import shah.MockAShop.Models.Seller;
import shah.MockAShop.Repository.SellerRepo;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class SellerService {

  @Autowired
  private SellerRepo sellerRepo;

  // FIND ALL
  public ResponseEntity<List<Seller>> getSellers() {
    List<Seller> findAll = sellerRepo.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(findAll);
  }
 
  // FIND ONE
  public ResponseEntity<?> getSellerById(int id) {
    Seller result = new Seller();
    try {
      result = sellerRepo.findById(id).get();
    } catch (Exception e) {
      result.setSeller_id(id);
      return createSimpleJSONResponse(HttpStatus.NOT_FOUND, "Resource not found");
    }
    return ResponseEntity.ok(result);
  }

  // ADD ONE
  public ResponseEntity<String> addSeller(Seller c, BindingResult result) {
    boolean ifExists = sellerRepo.existsById(c.getSeller_id());
    if (ifExists)
      return createSimpleJSONResponse(BAD_REQUEST, "Resource exists");
    if (result.hasErrors()) {
      System.out.println(result);
      return createSimpleJSONResponse(BAD_REQUEST, result.getFieldError().getDefaultMessage());
      }
    try {
      sellerRepo.save(c);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return createSimpleJSONResponse(BAD_REQUEST, e.getLocalizedMessage());
    }
    return createSimpleJSONResponse(CREATED, "Resource created");
  }

  // UPDATE ONE
  public ResponseEntity<String> updateSeller(Seller c) {
    boolean ifExists = sellerRepo.existsById(c.getSeller_id());
  
    if (!ifExists)
      return createSimpleJSONResponse(BAD_REQUEST, "Resource doesnt exists");
    try {
      sellerRepo.save(c);
    } catch (Exception e) {
      System.out.println(e.getLocalizedMessage());
      return createSimpleJSONResponse(BAD_REQUEST, e.getLocalizedMessage());
    }
    return createSimpleJSONResponse(OK, "Resource updated");
  }

  // DELETE ONE
  public ResponseEntity<String> deleteSeller(int c) {

    try {
      sellerRepo.deleteById(c);
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
