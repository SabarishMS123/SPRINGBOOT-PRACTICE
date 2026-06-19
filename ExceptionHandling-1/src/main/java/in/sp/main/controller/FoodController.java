package in.sp.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.sp.main.service.FoodService;

@RestController
@RequestMapping("/restaurant")
public class FoodController {

    @Autowired
    private FoodService foodService;

    // API: http://localhost:8080/restaurant/order?item=dosa
    @GetMapping("/order")
    public String orderFood(@RequestParam("item") String item) {
        return foodService.orderFood(item);
    }
}
