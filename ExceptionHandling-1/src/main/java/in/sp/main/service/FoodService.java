package in.sp.main.service;

import org.springframework.stereotype.Service;

import in.sp.main.entity.Food;
import in.sp.main.exception.FoodNotAvailableException;

@Service
public class FoodService {

    public String orderFood(String item) {
        String normalizedItem = item.trim().toLowerCase();

        // Dummy data (instead of DB for now)
        boolean isAvailable = !(normalizedItem.equals("biryani") || normalizedItem.equals("biriyani"));

        Food food = new Food(1L, item, 120.0,isAvailable);

        if (!food.isAvailable()) {
            throw new FoodNotAvailableException(food.getName() + " is not available today");
        }

        return food.getName() + " is prepared successfully";
    }
}
