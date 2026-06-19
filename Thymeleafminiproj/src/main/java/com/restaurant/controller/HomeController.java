package com.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("restaurantName", "Spice Garden Restaurant");
        model.addAttribute("tagline", "Experience the Authentic Flavors of India");
        model.addAttribute("openingHours", "11:00 AM - 10:00 PM");
        model.addAttribute("phoneNumber", "+1 234 567 8900");
        model.addAttribute("address", "123 Food Street, Culinary District");
        return "home";
    }
}