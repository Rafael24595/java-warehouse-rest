package com.warehouse.app.beans.product.product;

import com.warehouse.app.beans.product.situation.ProductSituationService;
import com.warehouse.app.structures.DataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSituationService productSituationService;

    @Autowired
    private FactoryProduct factoryCreateProduct;

    @GetMapping
    public List<Product> getProducts () {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct (@PathVariable("id") Long id) {
        return productService.get(id);
    }

    @PostMapping
    public ResponseEntity<Product> postProduct(@RequestBody(required = false) DataStructure<Object> payload) throws Exception {
        Product product = factoryCreateProduct.getInstance(payload);
        product = productService.insert(product);
        product = factoryCreateProduct.getInstance(product.getId(), payload);
        productSituationService.insert(product.getSituation());
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> putProduct(@PathVariable("id") Long id, @RequestBody(required = false) DataStructure<Object> payload) throws Exception {
        Product product = factoryCreateProduct.getInstance(id, payload);
        productSituationService.insert(product.getSituation());
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        productService.delete(id);
    }

}
