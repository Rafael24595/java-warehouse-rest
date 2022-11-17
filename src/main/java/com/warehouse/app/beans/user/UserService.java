package com.warehouse.app.beans.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

}
