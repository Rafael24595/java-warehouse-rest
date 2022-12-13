package com.warehouse.app.api.user;

import com.warehouse.app.domain.user.User;
import com.warehouse.app.service.user.UserService;
import com.warehouse.app.domain.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getUser () {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser (@PathVariable("id") Long id) {
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody(required = false) DataMap<Object> payload) throws Exception {
        User user = service.insert(payload);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> putUser(@PathVariable("id") Long id, @RequestBody(required = false) DataMap<Object> payload) throws Exception {
        User user = service.update(id, payload);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
