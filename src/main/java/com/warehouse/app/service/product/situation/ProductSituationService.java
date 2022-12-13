package com.warehouse.app.service.product.situation;

import com.warehouse.app.domain.DataMap;
import com.warehouse.app.service.WarehouseService;
import com.warehouse.app.domain.product.product.Product;
import com.warehouse.app.domain.product.situation.ProductSituation;
import com.warehouse.app.repository.product.situation.ProductSituationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public ProductSituation insert(DataMap<Object> payload) {
        return null;
    }

    @Override
    public ProductSituation update(Long id, DataMap<Object> payload) throws Exception {
        return null;
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
