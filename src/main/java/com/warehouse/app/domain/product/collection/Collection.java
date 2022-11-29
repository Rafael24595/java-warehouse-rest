package com.warehouse.app.domain.product.collection;

import com.warehouse.app.domain.WarehouseEntity;

import javax.persistence.*;

@Entity
public class Collection implements WarehouseEntity<Collection> {

    public static final String ID = "id";
    public static final String NAME = "name";

    @Id
    @SequenceGenerator(
            name = "collection_sequence",
            sequenceName = "collection_sequence_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "collection_sequence"
    )
    @Column(name = ID, nullable = false, unique = true)
    private Long id;
    @Column(name = NAME, nullable = false, unique = true)
    private String name;

    @Override
    public Collection update(Collection entity) {
        return null;
    }

    @Override
    public Collection clone() {
        return null;
    }
}
