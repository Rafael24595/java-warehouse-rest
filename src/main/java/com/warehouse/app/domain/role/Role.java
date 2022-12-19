package com.warehouse.app.domain.role;

import com.warehouse.app.domain.WarehouseEntity;

import javax.persistence.*;

@Entity
@Table(name = "db_roles", uniqueConstraints = {
        @UniqueConstraint(
                name = "uc_roles",
                columnNames = {"name"})
})
public class Role implements WarehouseEntity<Role> {

    public static final String ID = "id";
    public static final String NAME = "name";

    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )
    @Column(name = ID, nullable = false)
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
    public Role update(Role entity) {
        setName(entity.getName());
        return this;
    }

    @Override
    public Role clone() {
        return null;
    }

}
