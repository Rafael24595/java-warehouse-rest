package com.warehouse.app.beans.platform;

import com.warehouse.app.beans.WarehouseEntity;

import javax.persistence.*;

@Entity
@Table(name = "db_platforms")
public class Platform implements WarehouseEntity<Platform> {

    @Id
    @SequenceGenerator(
            name = "platform_secuence",
            sequenceName = "secuence_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secuence_name"
    )
    // Base ID
    private Long id;
    // UK
    private String name;
    private String owner;

    @Override
    public Platform update(Platform entity) {
        return null;
    }

    @Override
    public Platform clone() {
        return null;
    }
}
