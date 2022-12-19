package com.warehouse.app.factory.role;

import com.warehouse.app.constant.ExceptionMessages;
import com.warehouse.app.domain.DataMap;
import com.warehouse.app.domain.platform.Platform;
import com.warehouse.app.domain.role.Role;
import com.warehouse.app.factory.WarehouseFactory;
import com.warehouse.app.repository.role.RoleRepository;
import com.warehouse.app.tools.MessageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Component
public class FactoryRole implements WarehouseFactory<Role> {

    private static final String DEFAULT_USER = "USER";
    @Autowired
    private RoleRepository repository;

    @Override
    public Role getInstance(Long id) {
        Optional<Role> role = repository.findById(id);
        if(role.isEmpty()){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "Role", id);
            throw new NoSuchElementException(message);
        }
        return role.get();
    }

    @Override
    public Role getInstance(DataMap<Object> dataStructure) {
        Role role = new Role();

        try {
            role.setName(dataStructure.getStringHard(Platform.NAME));
        }catch (IllegalArgumentException e){
            String message = MessageBuilder.build(ExceptionMessages.REQUEST.BAD_JSON_FORMAT, e.getMessage());
            throw new IllegalArgumentException(message);
        }

        return role;
    }

    public Role getDefault(){
        Optional<Role> roleOptional = repository.findByName(DEFAULT_USER);
        if(roleOptional.isEmpty()){
            String message = MessageBuilder.build(ExceptionMessages.ENTITY.NOT_FOUND_DEFAULT, "role");
            throw new NoSuchElementException(message);
        }

        return roleOptional.get();
    }

}
