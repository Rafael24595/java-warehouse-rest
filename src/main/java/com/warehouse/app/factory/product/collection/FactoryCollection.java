package com.warehouse.app.factory.product.collection;

import com.warehouse.app.factory.WarehouseFactory;
import com.warehouse.app.domain.product.collection.Collection;
import com.warehouse.app.repository.product.collection.CollectionRepository;
import com.warehouse.app.domain.DataMap;
import com.warehouse.app.constant.ExceptionMessages;
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
    public Collection getInstance(DataMap<Object> dataStructure) {
        return null;
    }
}
