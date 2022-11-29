package com.warehouse.app.service.product.product;

import com.warehouse.app.service.WarehouseService;
import com.warehouse.app.domain.product.product.Product;
import com.warehouse.app.repository.product.product.ProductRepository;
import com.warehouse.app.constant.ExceptionMessages;
import com.warehouse.app.tools.MessageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService implements WarehouseService<Product> {

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
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "Product", id);
            throw new NoSuchElementException(message);
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
