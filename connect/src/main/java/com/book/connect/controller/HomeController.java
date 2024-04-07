package com.book.connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
     

     @GetMapping("/home")
     public String showBookDetails(Model model) {
          return "home"; // Return the name of the HTML template
     }
}
