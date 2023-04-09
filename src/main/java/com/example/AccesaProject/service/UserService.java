package com.example.AccesaProject.service;

import com.example.AccesaProject.payload.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Integer id);
    UserDto updateUser(UserDto userDto,  Integer id);
    void deleteUserById(Integer id);
}
