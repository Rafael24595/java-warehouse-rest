package com.warehouse.app.beans.category;

import javax.persistence.*;

@Entity
@Table(name = "db_categories")
public class Category {

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

}
