package in.main.service;
import in.main.entity.User;

public interface UserService {
    boolean registerUser(User u);
    User loginUser(String email, String password); // Changed from boolean to User
}