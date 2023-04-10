package com.example.AccesaProject.controller;

import com.example.AccesaProject.payload.ObjectResponse;
import com.example.AccesaProject.payload.UserDto;
import com.example.AccesaProject.payload.UserDto;
import com.example.AccesaProject.service.UserService;
import com.example.AccesaProject.utils.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        log.info("UserDto: {}", userDto);
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ObjectResponse<UserDto> getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY_USER, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION_USER, required = false) String sortDir
    ) {
        log.info("Pagination: pageNo = {}, pageSize = {}, sortBy = {}, sortDir = {}", pageNo, pageSize, sortBy, sortDir);
        return userService.getAllUsers(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        log.info("UserDto id: {}",id);
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,
                                               @PathVariable(name = "id") Long id) {
        log.info("New userDto: {}, idOfUpdatedUser = {}", userDto, id);
        UserDto badgeResponse = userService.updateUser(userDto, id);
        return new ResponseEntity<>(badgeResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Long id) {
        log.info("The user with id = {} is deleted.",id);
        userService.deleteUserById(id);
        return new ResponseEntity<>("User entity deleted successfully.", HttpStatus.OK);
    }
}