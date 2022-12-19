package com.warehouse.app.api.role;

import com.warehouse.app.domain.DataMap;
import com.warehouse.app.domain.role.Role;
import com.warehouse.app.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @GetMapping
    public List<Role> getRoles () {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Role> getRole (@PathVariable("id") Long id) {
        return service.get(id);
    }

    @PostMapping
    public ResponseEntity<Role> postRole(@RequestBody(required = false) DataMap<Object> payload) throws Exception {
        Role role = service.insert(payload);
        return ResponseEntity.ok().body(role);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> putRole(@PathVariable("id") Long id, @RequestBody(required = false) DataMap<Object> payload) throws Exception {
        Role role = service.update(id, payload);
        return ResponseEntity.ok().body(role);
    }

    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
