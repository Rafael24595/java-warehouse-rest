package com.example.demo.entities.product;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> get(Long id) {
        return productRepository.findById(id);
    }

    public Product insert(Product product){
        return productRepository.save(product);
    }

    public Product update(Long id, Product productUpdate) throws Exception {
        if(!productRepository.existsById(id)){
            throw new NoSuchElementException("TODO:___");
        }
        Product product = get(id).get();
        product.update(productUpdate);
        return productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

}
