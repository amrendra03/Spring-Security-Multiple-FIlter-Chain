package com.authentication.authentication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authentication.authentication.model.UserA;

@Repository
public interface UserARepo extends JpaRepository<UserA, Long> {
   UserA findByUsername(String username);

}
