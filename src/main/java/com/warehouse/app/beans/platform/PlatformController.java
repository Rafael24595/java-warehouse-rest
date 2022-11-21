package com.warehouse.app.beans.platform;

import com.warehouse.app.structures.DataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/platform")
public class PlatformController {

    @Autowired
    private PlatformService service;
    @Autowired
    private FactoryPlatform factory;

    @GetMapping
    public List<Platform> getPlatforms () {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Platform> getPlatform (@PathVariable("id") Long id) {
        return service.get(id);
    }

    @PostMapping
    public void postPlatform(@RequestBody(required = false) DataStructure<Object> payload) throws Exception {
        Platform platform = factory.getInstance(payload);
        service.insert(platform);
    }

    @PutMapping("/{id}")
    public void putPlatform(@PathVariable("id") Long id, @RequestBody(required = false) DataStructure<Object> payload) throws Exception {
        Platform platform = new Platform();
        service.update(id, platform);
    }

    @DeleteMapping("/{id}")
    public void deletePlatform(@PathVariable("id") Long id) {
        service.delete(id);
    }


}
