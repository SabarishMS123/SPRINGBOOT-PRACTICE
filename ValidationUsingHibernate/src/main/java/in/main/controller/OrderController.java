package in.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.main.dto.OrderRequest;
import in.main.service.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/shopsy")
public class OrderController {

	 @Autowired
	 private OrderService ord;
	 
	 @PostMapping
	 public String placeOrder(@Valid @RequestBody OrderRequest oreq) {
		 return ord.placeOrder(oreq);
	 }
	 
	 
	 
}
