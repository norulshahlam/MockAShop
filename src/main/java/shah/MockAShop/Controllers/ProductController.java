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
import shah.MockAShop.Models.Product;
import shah.MockAShop.Service.ProductService;

@RestController
public class ProductController {

  @Autowired
  ProductService productService;

  @GetMapping("/products")
  public ResponseEntity<List<Product>> getProducts() {
    return productService.getProducts();
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<?> getProductById(@PathVariable("id") int id) {
    return productService.getProductById(id);
  }

  @PostMapping("/products")
  public ResponseEntity<String> addProduct(@Valid @RequestBody Product c, BindingResult result) {
    return productService.addProduct(c, result);
  }

  @PutMapping("/products")
  public ResponseEntity<String> updateProduct(@RequestBody Product c) {
    return productService.updateProduct(c);
  }

  @DeleteMapping("/products/{id}")
  public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
    return productService.deleteProduct(id);
  }
}
