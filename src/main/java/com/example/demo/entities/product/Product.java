package com.example.demo.entities.product;

import com.example.demo.entities.WarehouseEntity;
import com.example.demo.entities.product.situation.ProductSituation;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "db_products", uniqueConstraints = {
        @UniqueConstraint(
                name = "uc_products",
                columnNames = {"id", "name", "version", "platform", "format", "region", "type"})
})
public class Product implements WarehouseEntity<Product> {

    // Base ID
    @Id
    @SequenceGenerator(
            name = "product_secuence",
            sequenceName = "product_secuence_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_secuence"
    )
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    // UK
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "version")
    private String version;
    @Column(name = "platform", nullable = false)
    private Long platform;
    @Column(name = "format", nullable = false)
    private String format;
    @Column(name = "region", nullable = false)
    private String region;
    @Column(name = "type", nullable = false)
    private Long type;

    // Misc
    @Column(name = "date_origen", nullable = false)
    private Date dateOrigen;
    @Column(name = "user_audit", nullable = false)
    private Long userAudit;
    @JoinColumn(name = "situation_fk")
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductSituation situation;

    public Product() {
    }

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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getPlatform() {
        return platform;
    }

    public void setPlatform(Long platform) {
        this.platform = platform;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Date getDateOrigen() {
        return dateOrigen;
    }

    public void setDateOrigen(Date dateOrigen) {
        this.dateOrigen = dateOrigen;
    }

    public Long getUserAudit() {
        return userAudit;
    }

    public void setUserAudit(Long userAudit) {
        this.userAudit = userAudit;
    }

    public ProductSituation getSituation() {
        return situation;
    }

    public void setSituation(ProductSituation situation) {
        this.situation = situation;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public Product clone() {
        return null;
    }
}
