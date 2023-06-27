package hu.baksa.trading.store.api.rest;

import hu.baksa.trading.store.model.Product;
import hu.baksa.trading.store.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public @ResponseBody ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Product> post(@RequestBody Product newProduct){
        return ResponseEntity.ok(productService.addProduct(newProduct));
    }
}
