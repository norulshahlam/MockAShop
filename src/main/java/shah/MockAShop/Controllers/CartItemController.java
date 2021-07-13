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
import shah.MockAShop.Models.Cart_Items;
import shah.MockAShop.Service.CartItemsService;

@RestController
public class CartItemController {

  @Autowired
  CartItemsService cartItemsService;

  @GetMapping("/cart-items")
  public ResponseEntity<List<Cart_Items>> getCartItems() {
    return cartItemsService.getCartItems();
  }

  @GetMapping("/cart-items/{id}")
  public ResponseEntity<?> getCartItemsById(@PathVariable("id") int id) {
    return cartItemsService.getCartItemsById(id);
  }

  @PostMapping("/cart-items")
  public ResponseEntity<String> addCartItems(@Valid @RequestBody Cart_Items c, BindingResult result) {
    return cartItemsService.addCartItems(c, result);
  }

  @PutMapping("/cart-items")
  public ResponseEntity<String> updateCartItems(@RequestBody Cart_Items c) {
    return cartItemsService.updateCartItems(c);
  }

  @DeleteMapping("/cart-items/{id}")
  public ResponseEntity<String> deleteCartItems(@PathVariable("id") int id) {
    return cartItemsService.deleteCartItems(id);
  }
}
