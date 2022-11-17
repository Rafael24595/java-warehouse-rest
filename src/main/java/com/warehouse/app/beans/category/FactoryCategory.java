package com.warehouse.app.beans.category;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FactoryCategory {

    @Autowired
    private CategoryService service;

}
