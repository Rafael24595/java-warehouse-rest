package com.warehouse.app.beans.category;


import com.warehouse.app.beans.WarehouseFactory;
import com.warehouse.app.structures.DataStructure;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FactoryCategory implements WarehouseFactory<Category> {

    @Autowired
    private CategoryService service;

    @Override
    public Category getInstance(Long id) {
        return null;
    }

    @Override
    public Category getInstance(DataStructure<Object> dataStructure) {
        return null;
    }
}
