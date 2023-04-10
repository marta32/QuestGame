package com.example.AccesaProject.controller;

import com.example.AccesaProject.payload.ObjectResponse;
import com.example.AccesaProject.payload.UserDto;
import com.example.AccesaProject.payload.UserDto;
import com.example.AccesaProject.service.UserService;
import com.example.AccesaProject.utils.AppConstants;
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

    @GetMapping
    public ObjectResponse<UserDto> getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY_USER, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION_USER, required = false) String sortDir
    ){
        return userService.getAllUsers(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getBadgeById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateBadge(@RequestBody UserDto UserDto,
                                                @PathVariable(name = "id") Long id) {
        UserDto badgeResponse = userService.updateUser(UserDto, id);
        return new ResponseEntity<>(badgeResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBadge(@PathVariable(name = "id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("User entity deleted successfully.", HttpStatus.OK);
    }
}