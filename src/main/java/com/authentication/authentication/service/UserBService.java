package com.authentication.authentication.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authentication.authentication.dao.UserBRepo;
import com.authentication.authentication.model.UserB;

@Service
public class UserBService implements UserDetailsService {

   private final UserBRepo userBRepo;

   public UserBService(UserBRepo userARepo) {
      this.userBRepo = userARepo;
   }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      UserB user = userBRepo.findByUsername(username);
      if (user == null) {
         throw new UsernameNotFoundException("User not found");
      }
      return user;
   }

}