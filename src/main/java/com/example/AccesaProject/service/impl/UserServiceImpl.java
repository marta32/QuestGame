package com.example.AccesaProject.service.impl;

import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.mapper.UserMapper;
import com.example.AccesaProject.payload.ObjectResponse;
import com.example.AccesaProject.payload.UserDto;
import com.example.AccesaProject.repository.UserRepository;
import com.example.AccesaProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.mapUserDtoToUser(userDto);
        userRepository.save(user);
        return userMapper.mapUserToUserDto(user);
    }

    @Override
    public ObjectResponse<UserDto> getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer id) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {

    }
}
