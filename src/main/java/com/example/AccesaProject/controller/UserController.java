package com.example.AccesaProject.controller;

import com.example.AccesaProject.payload.UserDto;
import com.example.AccesaProject.payload.UserDto;
import com.example.AccesaProject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserDto> createBadge(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getBadgeById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateBadge(@RequestBody UserDto UserDto,
                                                @PathVariable(name = "id") Integer id) {
        UserDto badgeResponse = userService.updateUser(UserDto, id);
        return new ResponseEntity<>(badgeResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBadge(@PathVariable(name = "id") Integer id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User entity deleted successfully.", HttpStatus.OK);
    }
}