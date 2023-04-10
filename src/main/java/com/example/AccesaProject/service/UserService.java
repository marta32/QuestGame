package com.example.AccesaProject.service;

import com.example.AccesaProject.payload.ObjectResponse;
import com.example.AccesaProject.payload.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    ObjectResponse<UserDto> getAllUsers(Integer pageNo, Integer pageSize, String sortBy, String sortDir);
    UserDto updateUser(UserDto userDto,  Long id);
    void deleteUserById(Long id);
}
