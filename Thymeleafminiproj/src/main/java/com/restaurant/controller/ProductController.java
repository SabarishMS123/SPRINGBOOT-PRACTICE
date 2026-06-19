package com.restaurant.controller;

import com.restaurant.entity.Feedback;
import com.restaurant.entity.Order;
import com.restaurant.entity.Product;
import com.restaurant.entity.User;
import com.restaurant.repository.FeedbackRepository;
import com.restaurant.repository.OrderRepository;
import com.restaurant.repository.ProductRepository;
import com.restaurant.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private FeedbackRepository feedbackRepository;
    
    @Autowired
    private OrderRepository orderRepository;
    
    @GetMapping
    public String productsPage(Model model) {
        List<Product> products = productRepository.findAll();
        
        // Calculate average rating and feedback count for each product
        for (Product product : products) {
            Double avgRating = feedbackRepository.getAverageRatingForProduct(product);
            Long feedbackCount = feedbackRepository.getFeedbackCountForProduct(product);
            product.setAverageRating(avgRating != null ? avgRating : 0.0);
            product.setFeedbackCount(feedbackCount != null ? feedbackCount : 0L);
        }
        
        model.addAttribute("products", products);
        
        // Check if user is authenticated
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = auth != null && auth.isAuthenticated() && !auth.getName().equals("anonymousUser");
        model.addAttribute("isAuthenticated", isAuthenticated);
        
        return "products";
    }
    
    @GetMapping("/{id}")
    public String productDetails(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        
        // Get average rating
        Double avgRating = feedbackRepository.getAverageRatingForProduct(product);
        Long feedbackCount = feedbackRepository.getFeedbackCountForProduct(product);
        product.setAverageRating(avgRating != null ? avgRating : 0.0);
        product.setFeedbackCount(feedbackCount != null ? feedbackCount : 0L);
        
        // Get all feedback for this product
        List<Feedback> feedbacks = feedbackRepository.findByProductOrderByCreatedAtDesc(product);
        
        model.addAttribute("product", product);
        model.addAttribute("feedbacks", feedbacks);
        
        // Check if user is authenticated
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isAuthenticated = auth != null && auth.isAuthenticated() && !auth.getName().equals("anonymousUser");
        model.addAttribute("isAuthenticated", isAuthenticated);
        
        return "product-details";
    }
    
    @PostMapping("/{id}/order")
    public String placeOrder(@PathVariable Long id,
                             @RequestParam Integer quantity,
                             RedirectAttributes redirectAttributes) {
        
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null || !auth.isAuthenticated() || auth.getName().equals("anonymousUser")) {
                redirectAttributes.addFlashAttribute("error", "Please login to place order");
                return "redirect:/login";
            }
            
            // Get the CustomUserDetails from authentication
            CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
            User user = customUserDetails.getUser();
            
            if (user == null) {
                redirectAttributes.addFlashAttribute("error", "User not found");
                return "redirect:/login";
            }
            
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            
            // Check stock
            if (product.getStockQuantity() <= 0) {
                redirectAttributes.addFlashAttribute("error", "Sorry, " + product.getName() + " is out of stock!");
                return "redirect:/products/" + id;
            }
            
            if (quantity > product.getStockQuantity()) {
                redirectAttributes.addFlashAttribute("error", "Only " + product.getStockQuantity() + " items available in stock!");
                return "redirect:/products/" + id;
            }
            
            // Calculate total price
            Double totalPrice = product.getPrice() * quantity;
            
            // Create order
            Order order = new Order(user, product, quantity, totalPrice);
            orderRepository.save(order);
            
            // Reduce stock
            product.setStockQuantity(product.getStockQuantity() - quantity);
            productRepository.save(product);
            
            redirectAttributes.addFlashAttribute("success", 
                String.format("Order placed successfully! You ordered %d x %s. Total: $%.2f", 
                quantity, product.getName(), totalPrice));
            
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error placing order: " + e.getMessage());
        }
        
        return "redirect:/products/" + id;
    }
    
    @PostMapping("/{id}/feedback")
    public String addFeedback(@PathVariable Long id, 
                              @RequestParam Integer rating,
                              @RequestParam String comment,
                              RedirectAttributes redirectAttributes) {
        
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth == null || !auth.isAuthenticated() || auth.getName().equals("anonymousUser")) {
                redirectAttributes.addFlashAttribute("error", "Please login to leave feedback");
                return "redirect:/login";
            }
            
            // Get the CustomUserDetails from authentication
            CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
            User user = customUserDetails.getUser();
            
            if (user == null) {
                redirectAttributes.addFlashAttribute("error", "User not found");
                return "redirect:/login";
            }
            
            Product product = productRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            
            // Create and save feedback
            Feedback feedback = new Feedback(product, user, rating, comment);
            feedbackRepository.save(feedback);
            
            redirectAttributes.addFlashAttribute("success", "Thank you for your feedback!");
            
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Error submitting feedback: " + e.getMessage());
        }
        
        return "redirect:/products/" + id;
    }
    
    // Initialize sample products (call this method once to populate database)
    @GetMapping("/init")
    public String initializeProducts() {
        if (productRepository.count() == 0) {
            // Your existing initialization code remains the same
        }
        return "redirect:/products";
    }
}