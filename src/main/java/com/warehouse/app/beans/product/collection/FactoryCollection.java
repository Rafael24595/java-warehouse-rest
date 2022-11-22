package com.warehouse.app.beans.product.collection;

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
public class FactoryCollection implements WarehouseFactory<Collection> {

    @Autowired
    private CollectionRepository repository;

    @Override
    public Collection getInstance(Long id) {
        Optional<Collection> collection = repository.findById(id);
        if(collection.isEmpty()){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "Product", id);
            throw new NoSuchElementException(message);
        }
        return collection.get();
    }

    @Override
    public Collection getInstance(DataStructure<Object> dataStructure) {
        return null;
    }
}
