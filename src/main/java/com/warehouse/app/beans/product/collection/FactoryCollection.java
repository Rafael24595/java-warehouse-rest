package com.warehouse.app.beans.product.collection;

import com.warehouse.app.beans.WarehouseFactory;
import com.warehouse.app.structures.DataStructure;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FactoryCollection implements WarehouseFactory<Collection> {

    @Autowired
    private CollectionService service;

    @Override
    public Collection getInstance(Long id) {
        return null;
    }

    @Override
    public Collection getInstance(DataStructure<Object> dataStructure) {
        return null;
    }
}
