package com.warehouse.app.factory.category;

import com.warehouse.app.factory.WarehouseFactory;
import com.warehouse.app.domain.platform.Platform;
import com.warehouse.app.domain.category.Category;
import com.warehouse.app.repository.category.CategoryRepository;
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
    public Category getInstance(DataMap<Object> dataStructure) {
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
