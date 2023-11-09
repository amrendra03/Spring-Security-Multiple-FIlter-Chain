package com.authentication.authentication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authentication.authentication.model.UserB;

@Repository
public interface UserBRepo extends JpaRepository<UserB, Long> {

   UserB findByUsername(String username);

}
