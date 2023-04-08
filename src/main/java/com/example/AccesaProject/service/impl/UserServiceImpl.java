package com.example.AccesaProject.service.impl;

import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.exception.ResourceNotFoundException;
import com.example.AccesaProject.mapper.UserMapper;
import com.example.AccesaProject.payload.ObjectResponse;
import com.example.AccesaProject.payload.UserDto;
import com.example.AccesaProject.repository.UserRepository;
import com.example.AccesaProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<User> users = userRepository.findAll(pageable);
        List<User> listOfUsers = users.getContent();
        List<UserDto> listOfDtoUsers = listOfUsers.stream()
                .map(user -> userMapper.mapUserToUserDto(user)).collect(Collectors.toList());

        return ObjectResponse.<UserDto>builder()
                .content(listOfDtoUsers)
                .pageNo(users.getNumber())
                .pageSize(users.getSize())
                .totalElements(users.getTotalElements())
                .totalPages(users.getTotalPages())
                .last(users.isLast())
                .build();
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
//        if (userDto.getUsername() != null){
//            user.setUsername(userDto.getUsername());
//        }
//        if(userDto.getTokens() != null){
//            user.setTokens(userDto.getTokens());
//        }
//        if(userDto.getPassword() != null){
//            user.setPassword(userDto.getPassword());
//        }
//        User updateUser = userRepository.save(user);
//        return userMapper.mapUserToUserDto(updateUser);
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User", "id",id));
        userRepository.delete(user);
    }

}
