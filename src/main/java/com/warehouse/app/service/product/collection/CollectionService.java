package com.warehouse.app.service.product.collection;

import com.warehouse.app.service.WarehouseService;
import com.warehouse.app.domain.product.collection.Collection;
import com.warehouse.app.repository.product.collection.CollectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CollectionService implements WarehouseService<Collection> {

    @Autowired
    private CollectionRepository repository;
    @Override
    public List<Collection> getAll() {
        return null;
    }

    @Override
    public Optional<Collection> get(Long id) {
        return Optional.empty();
    }

    @Override
    public Collection insert(Collection entity) {
        return null;
    }

    @Override
    public Collection update(Long id, Collection collection) throws Exception {
        return null;
    }

    @Override
    public void delete(Collection collection) {

    }

    @Override
    public void delete(Long id) {

    }
}
