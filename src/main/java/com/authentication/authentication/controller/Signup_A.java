package com.authentication.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.authentication.authentication.dao.UserARepo;
import com.authentication.authentication.model.UserA;

@Controller
@RequestMapping("/a")
public class Signup_A {

   @Autowired
   @Qualifier("bCryptPasswordEncoderA")
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Autowired
   private final UserARepo userARepo;

   public Signup_A(UserARepo userARepo) {
      this.userARepo = userARepo;
   }

   @RequestMapping("/signup_a")
   public String signup_a() {
      System.out.println("Signup A");
      return "signupA";
   }

   @PostMapping("/signup_a")
   public String signUpUser(@ModelAttribute() UserA user) {
      String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
      user.setPassword(encodedPassword);

      UserA usertemp = userARepo.findByUsername(user.getUsername());
      try {

         if (usertemp != null) {
            System.out.println(usertemp);
            System.out.println("userA Exist already ");
            return "signupA";
         } else {
            userARepo.save(user);
            System.out.println("saved");
         }
      } catch (Exception ex) {
         System.out.println(ex);
      }
      return "redirect:/a/login_a";
   }
}
