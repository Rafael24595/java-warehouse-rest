package com.warehouse.app.service.platform;

import com.warehouse.app.domain.DataMap;
import com.warehouse.app.factory.platform.FactoryPlatform;
import com.warehouse.app.service.WarehouseService;
import com.warehouse.app.domain.platform.Platform;
import com.warehouse.app.repository.platform.PlatformRepository;
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
public class PlatformService implements WarehouseService<Platform> {

    @Autowired
    private FactoryPlatform factory;
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
    public Platform insert(DataMap<Object> payload) {
        Platform platform = factory.getInstance(payload);
        return repository.save(platform);
    }

    @Override
    public Platform update(Long id, DataMap<Object> payload) throws Exception {
        if(!repository.existsById(id)){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "Platform", id);
            throw new NoSuchElementException(message);
        }
        Platform productUpdate = factory.getInstance(payload);
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
