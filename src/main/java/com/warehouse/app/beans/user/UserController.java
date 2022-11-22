package com.warehouse.app.beans.user;

import com.warehouse.app.structures.DataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private FactoryUser factory;

    @GetMapping
    public List<User> getUser () {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser (@PathVariable("id") Long id) {
        return service.get(id);
    }

    @PostMapping
    public void postUser(@RequestBody(required = false) DataStructure<Object> payload) throws Exception {
        User user = factory.getInstance(payload);
        service.insert(user);
    }

    @PutMapping("/{id}")
    public void putUser(@PathVariable("id") Long id, @RequestBody(required = false) DataStructure<Object> payload) throws Exception {
        User user = new User();
        service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
