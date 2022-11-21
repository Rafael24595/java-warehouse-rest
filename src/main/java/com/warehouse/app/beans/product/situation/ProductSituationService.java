package com.warehouse.app.beans.product.situation;

import com.warehouse.app.beans.WarehouseService;
import com.warehouse.app.beans.product.product.Product;
import com.warehouse.app.structures.ExceptionMessages;
import com.warehouse.app.tools.MessageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductSituationService implements WarehouseService<ProductSituation> {

    @Autowired
    private final ProductSituationRepository repository;

    @Override
    public List<ProductSituation> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ProductSituation> get(Long id) {
        return repository.findById(id);
    }

    public Optional<ProductSituation> getLastSituation(Product product) {
        return repository.findFirstByProductOrderByNumberSituationDesc(product);
    }

    public List<ProductSituation> getAllSituation(Product product) {
        return repository.findByProduct(product);
    }

    @Override
    public ProductSituation insert(ProductSituation productSituation) {
        return repository.save(productSituation);
    }

    @Override
    public ProductSituation update(Long id, ProductSituation productSituationUpdate) throws Exception {
        if(!repository.existsById(id)){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "ProductSituation", id);
            throw new NoSuchElementException(message);
        }
        ProductSituation productSituation = get(id).get();
        productSituation.update(productSituationUpdate);
        return repository.save(productSituation);
    }

    @Override
    public void delete(ProductSituation productSituation) {
        repository.delete(productSituation);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
