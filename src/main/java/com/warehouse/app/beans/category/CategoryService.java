package com.warehouse.app.beans.category;

import com.warehouse.app.beans.WarehouseService;
import com.warehouse.app.beans.product.product.Product;
import com.warehouse.app.structures.ExceptionMessages;
import com.warehouse.app.tools.MessageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryService implements WarehouseService<Category> {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Category insert(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Long id, Category categoryUpdate) throws Exception {
        if(!repository.existsById(id)){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "Product", id);
            throw new NoSuchElementException(message);
        }
        Category category = get(id).get();
        category.update(categoryUpdate);
        return repository.save(category);
    }

    @Override
    public void delete(Category category) {
        repository.delete(category);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
