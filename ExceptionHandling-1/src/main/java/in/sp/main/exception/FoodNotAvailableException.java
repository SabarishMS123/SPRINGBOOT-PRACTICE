package in.sp.main.exception;

public class FoodNotAvailableException extends RuntimeException {

    // Constructor
    public FoodNotAvailableException(String message) {
        super(message);
    }
}
