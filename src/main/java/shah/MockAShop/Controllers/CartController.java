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
import shah.MockAShop.Models.Cart;
import shah.MockAShop.Service.CartService;

@RestController
public class CartController {

  @Autowired
  CartService cartService;

  @GetMapping("/carts")
  public ResponseEntity<List<Cart>> getCarts() {
    return cartService.getCarts();
  }

  @GetMapping("/cart/{id}")
  public ResponseEntity<?> getCartById(@PathVariable("id") int id) {
    return cartService.getCartById(id);
  }

  @PostMapping("/cart")
  public ResponseEntity<String> addCart(@Valid @RequestBody Cart c, BindingResult result) {
    return cartService.addCart(c, result);
  }

  @PutMapping("/cart")
  public ResponseEntity<String> updateCart(@RequestBody Cart c) {
    return cartService.updateCart(c);
  }

  @DeleteMapping("/cart/{id}")
  public ResponseEntity<String> deleteCart(@PathVariable("id") int id) {
    return cartService.deleteCart(id);
  }
}
