package com.warehouse.app.beans.user;

import com.warehouse.app.beans.WarehouseFactory;
import com.warehouse.app.structures.DataStructure;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FactoryUser implements WarehouseFactory<User> {

    @Autowired
    private UserService service;

    public User getInstance(Long id){
        return null;
    }

    public User getInstance(DataStructure<Object> dataStructure){
        User user = new User();

        try {
        }catch (Exception e){
        }

        return user;
    }

}
