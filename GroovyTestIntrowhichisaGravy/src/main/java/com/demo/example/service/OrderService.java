package com.demo.example.service;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public double calculateFinalAmount(double amount) {
        if (amount > 5000) {
            return amount * 0.9;
        }
        return amount;
    }
}

