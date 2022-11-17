package com.warehouse.app.beans.platform;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PlatformService {

    @Autowired
    private final PlatformRepository repository;

    public Optional<Platform> get(Long id) {
        return repository.findById(id);
    }

}
