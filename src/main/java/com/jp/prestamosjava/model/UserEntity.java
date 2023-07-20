package com.jp.prestamosjava.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user", schema = "prestamos")
public class UserEntity {
//This tag works for automatic values on the table, in this case I wanted to use the phone number as an id, so the id would be manual and not automatic.
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "user")
    private String user;
    @Basic
    @Column(name = "password")
    private String password;

    public UserEntity() {

    }

    public UserEntity(Long id, String name, String user, String password) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.password = password;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
