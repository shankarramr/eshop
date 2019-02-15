package com.gmail.shankar2k5.eshop.userservice.repository;

import com.gmail.shankar2k5.eshop.userservice.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    public User findByEmailAddress(@Param("emailAddress") String emailAddress);

}