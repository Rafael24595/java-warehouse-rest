package com.example.demo.entities.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts () {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct (@PathVariable("id") Long id) {
        return productService.get(id);
    }

    @PostMapping
    public void postProduct(@RequestBody(required = false) Map<String, Object> payload) throws Exception {
        Product product = new Product();
        productService.insert(product);
    }

    @PutMapping("/{id}")
    public void putProduct(@PathVariable("id") Long id, @RequestBody(required = false) Map<String, Object> payload) throws Exception {
        Product product = new Product();
        productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        productService.delete(id);
    }

}
