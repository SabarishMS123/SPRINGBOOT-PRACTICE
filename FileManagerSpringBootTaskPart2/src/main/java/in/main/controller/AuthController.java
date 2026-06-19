package in.main.controller;



import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {

        String username = user.get("username");
        String password = user.get("password");

        if ("admin".equals(username) && "1234".equals(password)) {
            return "Login Successful";
        } else {
            return "Invalid Credentials";
        }
    }
}
