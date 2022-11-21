package com.warehouse.app.beans.user;

import com.warehouse.app.beans.WarehouseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "db_users")
public class User implements WarehouseEntity<User> {

    public static final String ID = "id";
    public static final String NICKNAME = "nickname";
    public static final String NAME = "name";
    public static final String SURNAME_1 = "surname_1";
    public static final String SURNAME_2 = "surname_2";
    public static final String DATE_ORIGEN = "date_origen";
    public static final String LEVEL = "level";

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
    @Column(name = ID, nullable = false, unique = true)
    private Long id;
    @Column(name = NICKNAME, nullable = false, unique = true)
    private String nickName;
    @Column(name = NAME, nullable = false)
    private String name;
    @Column(name = SURNAME_1, nullable = false)
    private String surname1;
    @Column(name = SURNAME_2, nullable = false)
    private String surname2;
    @Column(name = DATE_ORIGEN, nullable = false)
    private Date dateOrigen;
    @Column(name = LEVEL, nullable = false)
    private Integer level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public Date getDateOrigen() {
        return dateOrigen;
    }

    public void setDateOrigen(Date dateOrigen) {
        this.dateOrigen = dateOrigen;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public User clone() {
        return null;
    }
}
