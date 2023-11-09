package com.authentication.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.authentication.authentication.dao.UserBRepo;
import com.authentication.authentication.model.UserB;

@Controller
@RequestMapping("/b")
public class Signup_B {

   @Autowired
   @Qualifier("bCryptPasswordEncoderB")
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   private final UserBRepo userBRepo;

   public Signup_B(UserBRepo userBRepo) {
      this.userBRepo = userBRepo;
   }

   @RequestMapping("/signup_b")
   public String signup_b() {
      System.out.println("Signup B");

      return "signupB";
   }

   @PostMapping("/signup_b")
   public String signUpUser(@ModelAttribute() UserB user) {
      String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
      user.setPassword(encodedPassword);

      UserB usertemp = userBRepo.findByUsername(user.getUsername());
      try {

         if (usertemp != null) {
            System.out.println(usertemp);
            System.out.println("userA Exist already ");
            return "signupA";
         } else {
            userBRepo.save(user);

            System.out.println("saved");
         }
      } catch (Exception ex) {
         System.out.println(ex);
      }
      return "redirect:/b/login_b";
   }
}
