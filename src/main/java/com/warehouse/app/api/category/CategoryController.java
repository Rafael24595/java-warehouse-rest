package com.warehouse.app.api.category;

import com.warehouse.app.domain.category.Category;
import com.warehouse.app.service.category.CategoryService;
import com.warehouse.app.factory.category.FactoryCategory;
import com.warehouse.app.domain.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Category> postCategory(@RequestBody(required = false) DataMap<Object> payload) throws Exception {
        Category category = factory.getInstance(payload);
        category = service.insert(category);
        return ResponseEntity.ok().body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> putCategory(@PathVariable("id") Long id, @RequestBody(required = false) DataMap<Object> payload) throws Exception {
        Category category = factory.getInstance(payload);
        category = service.update(id, category);
        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
