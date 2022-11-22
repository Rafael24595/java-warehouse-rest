package com.warehouse.app.beans.platform;

import com.warehouse.app.beans.WarehouseFactory;
import com.warehouse.app.structures.DataStructure;
import com.warehouse.app.structures.ExceptionMessages;
import com.warehouse.app.tools.MessageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Component
public class FactoryPlatform implements WarehouseFactory<Platform> {

    @Autowired
    private PlatformRepository repository;

    public Platform getInstance(Long id) {
        Optional<Platform> platform = repository.findById(id);
        if(platform.isEmpty()){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "Platform", id);
            throw new NoSuchElementException(message);
        }
        return platform.get();
    }

    @Override
    public Platform getInstance(DataStructure<Object> dataStructure) {
        Platform platform = new Platform();

        try {
            platform.setName(dataStructure.getStringHard(Platform.NAME));
            platform.setOwner(dataStructure.getStringHard(Platform.OWNER));
        }catch (IllegalArgumentException e){
            String message = MessageBuilder.build(ExceptionMessages.REQUEST.BAD_JSON_FORMAT, e.getMessage());
            throw new IllegalArgumentException(message);
        }

        return platform;
    }

}
