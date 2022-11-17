package com.warehouse.app.beans.platform;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class FactoryPlatform {

    @Autowired
    private PlatformService platformService;

    public Platform getInstance(Long id) {
        Optional<Platform> platform = platformService.get(id);
        return platform.get();
    }

}
