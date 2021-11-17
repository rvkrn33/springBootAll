package com.first.first.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.first.jwt.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
