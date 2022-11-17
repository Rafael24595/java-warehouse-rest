package com.warehouse.app.beans.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FactoryUser {

    @Autowired
    private UserService service;

}
