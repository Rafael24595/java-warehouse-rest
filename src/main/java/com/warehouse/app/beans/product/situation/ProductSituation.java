package com.warehouse.app.beans.product.situation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.warehouse.app.beans.WarehouseEntity;
import com.warehouse.app.beans.product.product.Product;
import com.warehouse.app.beans.user.User;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "db_products_situations", uniqueConstraints = {
        @UniqueConstraint(
                name = "uc_products_situations",
                columnNames = {"product_fk", "number_situation"})
})
public class ProductSituation implements WarehouseEntity<ProductSituation> {

    public static final String ID = "id";
    public static final String PRODUCT_FK = "product_fk";
    public static final String NUMBER_SITUATION = "number_situation";
    public static final String NAME_ALTERNATE = "name_alternate";
    public static final String DESCRIPTION = "description";
    public static final String EXTRA_01 = "extra_01";
    public static final String EXTRA_02 = "extra_02";
    public static final String EXTRA_03 = "extra_03";
    public static final String REFERENCE = "reference";
    public static final String RATING = "rating";
    public static final String AMOUNT = "amount";
    public static final String TAGS = "tags";
    public static final String LOCATION = "location";
    public static final String IMAGE_01 = "image_01";
    public static final String IMAGE_02 = "image_02";
    public static final String IMAGE_03 = "image_03";
    public static final String DATE_SITUATION = "date_situation";
    public static final String USER_AUDIT = "user_audit";
    public static final String COMMENT = "comment";


    // Base ID
    @Id
    @SequenceGenerator(
            name = "product_situation_sequence",
            sequenceName = "product_situation_sequence_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_situation_sequence_name"
    )
    @Column(name = ID, nullable = false, unique = true)
    private Long id;

    // UK
    @JoinColumn(name = PRODUCT_FK, nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore()
    private Product product;
    @Column(name = NUMBER_SITUATION, nullable = false)
    private Long numberSituation;

    // Description
    @Column(name = NAME_ALTERNATE)
    private String nameAlternate;
    @Column(name = DESCRIPTION)
    private String description;
    @Column(name = EXTRA_01)
    private String extra01;
    @Column(name = EXTRA_02)
    private String extra02;
    @Column(name = EXTRA_03)
    private String extra03;
    @Column(name = REFERENCE)
    private String reference;
    @Column(name = RATING)
    private Integer rating;
    @Column(name = AMOUNT)
    private Long amount;
    @Column(name = TAGS)
    private String tags;

    //System
    @Column(name = LOCATION)
    private String location;
    @Column(name = IMAGE_01)
    private String image01;
    @Column(name = IMAGE_02)
    private String image02;
    @Column(name = IMAGE_03)
    private String image03;

    // Misc
    @Column(name = DATE_SITUATION, nullable = false)
    private Date dateSituation;
    @JoinColumn(name = USER_AUDIT, nullable = false)
    @OneToOne(fetch = FetchType.EAGER)
    private User userSituation;
    @Column(name = COMMENT)
    private String comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getNumberSituation() {
        return numberSituation;
    }

    public void setNumberSituation(Long numberSituation) {
        this.numberSituation = numberSituation;
    }

    public String getNameAlternate() {
        return nameAlternate;
    }

    public void setNameAlternate(String nameAlternate) {
        this.nameAlternate = nameAlternate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtra01() {
        return extra01;
    }

    public void setExtra01(String extra01) {
        this.extra01 = extra01;
    }

    public String getExtra02() {
        return extra02;
    }

    public void setExtra02(String extra02) {
        this.extra02 = extra02;
    }

    public String getExtra03() {
        return extra03;
    }

    public void setExtra03(String extra03) {
        this.extra03 = extra03;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage01() {
        return image01;
    }

    public void setImage01(String image01) {
        this.image01 = image01;
    }

    public String getImage02() {
        return image02;
    }

    public void setImage02(String image02) {
        this.image02 = image02;
    }

    public String getImage03() {
        return image03;
    }

    public void setImage03(String image03) {
        this.image03 = image03;
    }

    public Date getDateSituation() {
        return dateSituation;
    }

    public void setDateSituation(Date dateSituation) {
        this.dateSituation = dateSituation;
    }

    public User getUserSituation() {
        return userSituation;
    }

    public void setUserSituation(User userSituation) {
        this.userSituation = userSituation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public ProductSituation update(ProductSituation entity) {
        return null;
    }

    @Override
    public ProductSituation clone() {
        return null;
    }
}
