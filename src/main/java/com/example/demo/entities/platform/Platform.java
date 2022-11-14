package com.example.demo.entities.platform;

import javax.persistence.*;

@Entity
@Table(name = "db_platforms")
public class Platform {

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

}
