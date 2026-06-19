package com.example.controller;
//import org.springframework.web.bind.annotation.RequestController;
import com.example.exception.UserException;
import com.example.modal.User;
import com.example.payload.dto.UserDto;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.mapper.UserMapper;
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
   
	private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getUserProfile

            (
                    @RequestHeader("Authorization")String jwt
            ) throws UserException, Exception {
        User user =userService.getUserFromJwtToken(jwt);
        return ResponseEntity.ok(UserMapper.toDto(user));
    }
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById

            (
                    @RequestHeader("Authorization")String jwt,
                    @PathVariable Long id
            ) throws UserException, Exception {
    	User user =userService.getUserById(id);
   
        
        return ResponseEntity.ok(UserMapper.toDto(user));
    }

}
