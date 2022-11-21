package com.warehouse.app.beans.category;

import com.warehouse.app.beans.WarehouseEntity;

import javax.persistence.*;

@Entity
@Table(name = "db_categories")
public class Category implements WarehouseEntity<Category> {

    public static final String ID = "id";
    public static final String NAME = "name";

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
    @Column(name = ID, nullable = false, unique = true)
    private Long id;
    @Column(name = NAME, nullable = false, unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Category update(Category entity) {
        return null;
    }

    @Override
    public Category clone() {
        return null;
    }
}
