package com.ysh.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users2")
public class Users2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    public Users2() {}

    public Users2(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter/Setter 생략 가능
}