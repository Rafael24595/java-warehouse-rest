package com.warehouse.app.service.product.product;

import com.warehouse.app.domain.DataMap;
import com.warehouse.app.factory.product.product.IFactoryCreateProduct;
import com.warehouse.app.factory.product.product.IFactoryModifyProduct;
import com.warehouse.app.service.WarehouseService;
import com.warehouse.app.domain.product.product.Product;
import com.warehouse.app.repository.product.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService implements WarehouseService<Product> {

    @Autowired
    @Qualifier("Default_FactoryCreateProduct")
    private IFactoryCreateProduct factoryCreate;

    @Autowired
    @Qualifier("Default_FactoryModifyProduct")
    private IFactoryModifyProduct factoryModify;

    @Autowired
    private final ProductRepository repository;

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Optional<Product> get(Long id) {
        return repository.findById(id);
    }

    public Product insert(DataMap<Object> payload){
        return factoryCreate.save(payload);
    }

    public Product update(Long id, DataMap<Object> payload) throws Exception {
        return factoryModify.update(id, payload);
    }

    public void delete(Product product) {
        repository.delete(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
