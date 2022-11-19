package com.warehouse.app.beans.product.collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/collection")
public class CollectionController {

    @Autowired
    private CollectionService service;
    @Autowired
    private FactoryCollection factory;

}
