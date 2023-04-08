package com.example.AccesaProject.service.impl;

import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.exception.ResourceNotFoundException;
import com.example.AccesaProject.mapper.UserMapper;
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
    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return userMapper.mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        if (userDto.getName() != null){
            user.setName(userDto.getName());
        }
        if(userDto.getTokens() != null){
            user.setTokens(userDto.getTokens());
        }
        User updateUser = userRepository.save(user);
        return userMapper.mapUserToUserDto(updateUser);
    }

    @Override
    public void deleteUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User", "id",id));
        userRepository.delete(user);
    }

}
