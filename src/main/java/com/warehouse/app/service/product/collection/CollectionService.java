package com.warehouse.app.service.product.collection;

import com.warehouse.app.domain.DataMap;
import com.warehouse.app.factory.product.collection.FactoryCollection;
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
    private FactoryCollection factory;
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
    public Collection insert(DataMap<Object> payload) {
        Collection collection = factory.getInstance(payload);
        return repository.save(collection);
    }

    @Override
    public Collection update(Long id, DataMap<Object> payload) throws Exception {
        return null;
    }

    @Override
    public void delete(Collection collection) {

    }

    @Override
    public void delete(Long id) {

    }
}
