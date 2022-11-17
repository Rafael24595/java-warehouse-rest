package com.warehouse.app.beans.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService service;
    @Autowired
    private FactoryCategory factory;

}
