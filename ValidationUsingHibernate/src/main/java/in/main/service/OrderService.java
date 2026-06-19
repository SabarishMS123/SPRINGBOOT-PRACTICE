package in.main.service;

import org.springframework.stereotype.Service;

import in.main.dto.OrderRequest;
import in.main.entity.Order;
import jakarta.validation.Valid;

@Service
public class OrderService {
   
	 public String placeOrder(@Valid OrderRequest oreq) {
		 return "Order placed successfully for : "+ oreq.getCustomername();
	 }
}
