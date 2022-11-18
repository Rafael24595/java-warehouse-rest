package com.warehouse.app.beans.user;

import com.warehouse.app.beans.WarehouseEntity;

import javax.persistence.*;

@Entity
@Table(name = "db_users")
public class User implements WarehouseEntity<User> {

    @Id
    @SequenceGenerator(
            name = "user_secuence",
            sequenceName = "product_secuence_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_secuence"
    )
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public User clone() {
        return null;
    }
}
