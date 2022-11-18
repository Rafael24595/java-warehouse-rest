package com.warehouse.app.beans.product.situation;

import com.warehouse.app.beans.WarehouseService;
import com.warehouse.app.beans.product.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductSituationService implements WarehouseService<ProductSituation> {

    @Autowired
    private final ProductSituationRepository productSituationRepository;

    @Override
    public List<ProductSituation> getAll() {
        return null;
    }

    @Override
    public Optional<ProductSituation> get(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductSituation insert(ProductSituation entity) {
        return null;
    }

    @Override
    public ProductSituation update(Long id, Product productUpdate) throws Exception {
        return null;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void delete(Long id) {

    }
}
