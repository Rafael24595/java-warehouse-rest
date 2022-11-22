package com.warehouse.app.beans.category;

import com.warehouse.app.beans.WarehouseFactory;
import com.warehouse.app.beans.platform.Platform;
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
public class FactoryCategory implements WarehouseFactory<Category> {

    @Autowired
    private CategoryRepository repository;

    @Override
    public Category getInstance(Long id) {
        Optional<Category> category = repository.findById(id);
        if(category.isEmpty()){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "Category", id);
            throw new NoSuchElementException(message);
        }
        return category.get();
    }

    @Override
    public Category getInstance(DataStructure<Object> dataStructure) {
        Category category = new Category();

        try {
            category.setName(dataStructure.getStringHard(Platform.NAME));
        }catch (IllegalArgumentException e){
            String message = MessageBuilder.build(ExceptionMessages.REQUEST.BAD_JSON_FORMAT, e.getMessage());
            throw new IllegalArgumentException(message);
        }

        return category;
    }
}
