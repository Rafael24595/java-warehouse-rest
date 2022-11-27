package com.warehouse.app.beans.product.collection;

import com.warehouse.app.structures.DataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/collection")
public class CollectionController {

    @Autowired
    private CollectionService service;
    @Autowired
    private FactoryCollection factory;

    @GetMapping
    public List<Collection> getCollections () {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Collection> getCollection (@PathVariable("id") Long id) {
        return service.get(id);
    }

    @PostMapping
    public void postCollection(@RequestBody(required = false) DataStructure<Object> payload) throws Exception {
        Collection collection = factory.getInstance(payload);
        service.insert(collection);
    }

    @PutMapping("/{id}")
    public void putCollection(@PathVariable("id") Long id, @RequestBody(required = false) DataStructure<Object> payload) throws Exception {
        Collection collection = new Collection();
        service.update(id, collection);
    }

    @DeleteMapping("/{id}")
    public void deletePlatform(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
