package com.spring_boot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_boot.demo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{


}
