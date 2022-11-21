package com.warehouse.app.beans.category;

import com.warehouse.app.structures.DataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService service;
    @Autowired
    private FactoryCategory factory;

    @GetMapping
    public List<Category> getCategories () {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory (@PathVariable("id") Long id) {
        return service.get(id);
    }

    @PostMapping
    public void postCategory(@RequestBody(required = false) DataStructure<Object> payload) throws Exception {
        Category category = factory.getInstance(payload);
        service.insert(category);
    }

    @PutMapping("/{id}")
    public void putCategory(@PathVariable("id") Long id, @RequestBody(required = false) DataStructure<Object> payload) throws Exception {
        Category category = new Category();
        service.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
