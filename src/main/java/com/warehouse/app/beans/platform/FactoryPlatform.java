package com.warehouse.app.beans.platform;

import com.warehouse.app.beans.WarehouseFactory;
import com.warehouse.app.structures.DataStructure;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class FactoryPlatform implements WarehouseFactory<Platform> {

    @Autowired
    private PlatformService platformService;

    public Platform getInstance(Long id) {
        Optional<Platform> platform = platformService.get(id);
        return platform.get();
    }

    @Override
    public Platform getInstance(DataStructure<Object> dataStructure) {
        return null;
    }

}
