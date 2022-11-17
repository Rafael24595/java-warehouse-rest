package com.warehouse.app.beans.category;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

}
