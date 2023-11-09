package com.authentication.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/b")
public class Login_B {

   @RequestMapping("/login_b")
   public String login() {
      System.out.println("login B");
      return "loginB.html";
   }

}
