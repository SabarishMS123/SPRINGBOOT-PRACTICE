package in.sp.main.dto.errorResponse;

public class ErrorResponse {

    private String message;
    private int status;

    // Constructor
    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}