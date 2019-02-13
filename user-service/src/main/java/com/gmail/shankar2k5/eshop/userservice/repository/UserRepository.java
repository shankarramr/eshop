package com.gmail.shankar2k5.eshop.userservice.repository;

import com.gmail.shankar2k5.eshop.userservice.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}