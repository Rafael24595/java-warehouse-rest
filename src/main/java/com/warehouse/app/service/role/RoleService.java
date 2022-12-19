package com.warehouse.app.service.role;

import com.warehouse.app.constant.ExceptionMessages;
import com.warehouse.app.domain.DataMap;
import com.warehouse.app.domain.role.Role;
import com.warehouse.app.factory.role.FactoryRole;
import com.warehouse.app.repository.role.RoleRepository;
import com.warehouse.app.service.WarehouseService;
import com.warehouse.app.tools.MessageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RoleService implements WarehouseService<Role> {

    @Autowired
    private FactoryRole factory;
    @Autowired
    private RoleRepository repository;

    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Role> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public Role insert(DataMap<Object> payload) {
        Role role = factory.getInstance(payload);
        return repository.save(role);
    }

    @Override
    public Role update(Long id, DataMap<Object> payload) throws Exception {
        if(!repository.existsById(id)){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "Product", id);
            throw new NoSuchElementException(message);
        }
        Role roleUpdate = factory.getInstance(payload);
        Role role = get(id).get();
        role.update(roleUpdate);
        return repository.save(role);
    }

    @Override
    public void delete(Role entity) {
        repository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
