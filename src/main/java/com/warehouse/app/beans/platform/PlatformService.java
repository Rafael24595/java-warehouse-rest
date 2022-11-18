package com.warehouse.app.beans.platform;

import com.warehouse.app.beans.WarehouseService;
import com.warehouse.app.beans.product.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PlatformService implements WarehouseService<Platform> {

    @Autowired
    private final PlatformRepository repository;

    @Override
    public List<Platform> getAll() {
        return null;
    }

    public Optional<Platform> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Platform insert(Platform entity) {
        return null;
    }

    @Override
    public Platform update(Long id, Product productUpdate) throws Exception {
        return null;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void delete(Long id) {

    }

}
