package com.warehouse.app.api.product.collection;

import com.warehouse.app.domain.product.collection.Collection;
import com.warehouse.app.service.product.collection.CollectionService;
import com.warehouse.app.domain.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/collection")
public class CollectionController {

    @Autowired
    private CollectionService service;

    @GetMapping
    public List<Collection> getCollections () {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Collection> getCollection (@PathVariable("id") Long id) {
        return service.get(id);
    }

    @PostMapping
    public void postCollection(@RequestBody(required = false) DataMap<Object> payload) throws Exception {
        service.insert(payload);
    }

    @PutMapping("/{id}")
    public void putCollection(@PathVariable("id") Long id, @RequestBody(required = false) DataMap<Object> payload) throws Exception {
        service.update(id, payload);
    }

    @DeleteMapping("/{id}")
    public void deletePlatform(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
