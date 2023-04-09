package com.example.AccesaProject.service;

import com.example.AccesaProject.payload.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    UserDto updateUser(UserDto userDto,  Long id);
    void deleteUserById(Long id);
}
