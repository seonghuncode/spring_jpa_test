package com.ysh.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ysh.test.entity.Users2;

public interface TestRepository extends JpaRepository<Users2, Long> {
    // 기본 CRUD는 자동 생성됨
    // 추가 쿼리 메서드도 정의 가능
    Users2 findByEmail(String email);  // 예시
}