package in.sp.main.service;

import org.springframework.stereotype.Service;

import in.sp.main.dto.OrderRequest;

@Service
public class OrderService {

    public String placeOrder(OrderRequest request) {
        // Business logic
        return "Order placed successfully for " + request.getCustomerName();
    }
}