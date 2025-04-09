package com.ysh.test.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;


/*
@Entity	jakarta.persistence.Entity	최신 JPA 표준 API (Jakarta EE 9 이상)
@Entity	javax.persistence.Entity	구버전 JPA 표준 API (Jakarta EE 8 이하)
@Entity	org.hibernate.annotations.Entity	Hibernate 고유 어노테이션 (비권장) 

Spring Framework 5.x 이하 + Hibernate 5.x 사용 시
👉 javax.persistence.* 사용
Spring 최신 버전 (6.x) + Hibernate 6.x 이상
👉 jakarta.persistence.* 사용 (Spring Boot 3.x도 동일)
*/

@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    public User() {}
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters & Setters 생략 가능
}