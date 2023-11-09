package com.authentication.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.authentication.authentication.model.UserA;

@Controller
@RequestMapping("/a")
public class Login_A {

   @RequestMapping("/login_a")
   public String login(@ModelAttribute() UserA user) {
      System.out.println(user);
      System.out.println("login A");
      return "loginA.html";
   }

}