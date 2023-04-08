package com.example.AccesaProject.service;

import com.example.AccesaProject.payload.ObjectResponse;
import com.example.AccesaProject.payload.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    ObjectResponse<UserDto> getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);
    UserDto getUserById(Integer id);
    UserDto updateUser(UserDto userDto,  Integer id);
    void deleteUserById(Integer id);
}
