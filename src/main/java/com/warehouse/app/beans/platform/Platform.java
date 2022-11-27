package com.warehouse.app.beans.platform;

import com.warehouse.app.beans.WarehouseEntity;

import javax.persistence.*;

@Entity
@Table(name = "db_platforms")
public class Platform implements WarehouseEntity<Platform> {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String OWNER = "owner";

    @Id
    @SequenceGenerator(
            name = "platform_sequence",
            sequenceName = "platform_sequence_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "platform_sequence_name"
    )
    @Column(name = ID, nullable = false, unique = true)
    private Long id;
    // UK
    @Column(name = NAME, nullable = false, unique = true)
    private String name;
    @Column(name = OWNER, nullable = false)
    private String owner;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public Platform update(Platform entity) {
        return null;
    }

    @Override
    public Platform clone() {
        return null;
    }
}
