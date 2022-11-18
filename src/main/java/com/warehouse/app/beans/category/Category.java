package com.warehouse.app.beans.category;

import com.warehouse.app.beans.WarehouseEntity;

import javax.persistence.*;

@Entity
@Table(name = "db_categories")
public class Category implements WarehouseEntity<Category> {

    @Id
    @SequenceGenerator(
            name = "category_secuence",
            sequenceName = "product_secuence_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_secuence"
    )
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Override
    public Category update(Category entity) {
        return null;
    }

    @Override
    public Category clone() {
        return null;
    }
}
