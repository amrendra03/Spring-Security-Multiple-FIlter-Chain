package com.authentication.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/b")
public class Welcome_B {

   @RequestMapping("/welcome_b")
   public String welcome_b() {
      System.out.println("welome_b...");

      return "welcome_b";
   }
}
