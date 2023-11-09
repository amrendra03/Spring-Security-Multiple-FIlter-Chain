package com.authentication.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a")
public class Welcome_A {

   @RequestMapping("/welcome_a")
   public String welcome_a() {
      System.out.println("welome_a...");
      return "welcome_a.html";
   }
}
