package com.warehouse.app.beans.platform;

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
public class PlatformService implements WarehouseService<Platform> {

    @Autowired
    private final PlatformRepository repository;

    @Override
    public List<Platform> getAll() {
        return repository.findAll();
    }

    public Optional<Platform> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Platform insert(Platform platform) {
        return repository.save(platform);
    }

    @Override
    public Platform update(Long id, Platform productUpdate) throws Exception {
        if(!repository.existsById(id)){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "Platform", id);
            throw new NoSuchElementException(message);
        }
        Platform platform = get(id).get();
        platform.update(productUpdate);
        return repository.save(platform);
    }

    @Override
    public void delete(Platform platform) {
        repository.delete(platform);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
