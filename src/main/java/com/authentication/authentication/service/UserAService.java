package com.authentication.authentication.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authentication.authentication.dao.UserARepo;
import com.authentication.authentication.model.UserA;

@Service
public class UserAService implements UserDetailsService {

   private final UserARepo userARepo;

   public UserAService(UserARepo userARepo) {
      this.userARepo = userARepo;
   }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      UserA user = userARepo.findByUsername(username);
      if (user == null) {
         throw new UsernameNotFoundException("User not found");
      }
      return user;
   }

}
