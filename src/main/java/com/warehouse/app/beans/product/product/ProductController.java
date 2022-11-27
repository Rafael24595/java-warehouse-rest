package com.warehouse.app.beans.product.product;

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
    private FactoryManageProduct factory;
    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts () {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct (@PathVariable("id") Long id) {
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<Product> postProduct(@RequestBody(required = false) DataStructure<Object> payload) throws Exception {
        Product product = factory.saveProduct(payload);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> putProduct(@PathVariable("id") Long id, @RequestBody(required = false) DataStructure<Object> payload) throws Exception {
        Product product = factory.updateProduct(id, payload);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
