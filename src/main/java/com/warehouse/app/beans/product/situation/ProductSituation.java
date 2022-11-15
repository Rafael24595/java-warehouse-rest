package com.warehouse.app.beans.product.situation;

import com.warehouse.app.beans.product.product.Product;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "db_products_situations", uniqueConstraints = {
        @UniqueConstraint(
                name = "uc_products_situations",
                columnNames = {"id", "product_fk", "number_situation"})
})
public class ProductSituation {

    // Base ID
    @Id
    @SequenceGenerator(
            name = "product_situation_secuence",
            sequenceName = "secuence_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "secuence_name"
    )
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    // UK
    @JoinColumn(name = "product_fk")
    @OneToOne(fetch = FetchType.LAZY)
    private Product product;
    @Column(name = "number_situation", nullable = false)
    private Long numberSituation;

    // Description
    @Column(name = "name_alternate")
    private String nameAlternate;
    @Column(name = "description")
    private String description;
    @Column(name = "extra_01")
    private String extra01;
    @Column(name = "extra_02")
    private String extra02;
    @Column(name = "extra_03")
    private String extra03;
    @Column(name = "reference")
    private String reference;
    @Column(name = "rating")
    private int rating;
    @Column(name = "amount")
    private long amount;
    @Column(name = "tags")
    private String tags;

    //System
    @Column(name = "location")
    private String location;
    @Column(name = "image_01")
    private String image01;
    @Column(name = "image_02")
    private String image02;
    @Column(name = "image_03")
    private String image03;

    // Misc
    @Column(name = "date_situation")
    private Date dateSituation;
    @Column(name = "user_situation")
    private Long userSituation;
    @Column(name = "comment")
    private String comment;

}
