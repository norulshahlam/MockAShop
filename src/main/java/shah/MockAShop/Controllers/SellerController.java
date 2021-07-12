package shah.MockAShop.Controllers;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shah.MockAShop.Models.Seller;
import shah.MockAShop.Service.SellerService;

@RestController
public class SellerController {

  @Autowired
  SellerService sellerService;

  @GetMapping("/")
  public String index() {
    return "home page";
  }

  @GetMapping("/sellers")
  public ResponseEntity<List<Seller>> getSellers() {
    return sellerService.getSellers();
  }

  @GetMapping("/seller/{id}")
  public ResponseEntity<?> getSellerById(@PathVariable("id") int id) {
   return sellerService.getSellerById(id);
  }

  @PostMapping("/seller")
  public ResponseEntity<String> addSeller(@Valid @RequestBody Seller c, BindingResult result) {
    return sellerService.addSeller(c, result);
  }
  @PutMapping("/seller")
  public ResponseEntity<String> updateSeller(@RequestBody Seller c) {
    return sellerService.updateSeller(c);
  }

  @DeleteMapping("/seller/{id}")
  public ResponseEntity<String> deleteSeller(@PathVariable("id") int id) {
    return sellerService.deleteSeller(id);
  }
}

