package com.example.AccesaProject.mapper;

import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.payload.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {
    @Autowired
    private BadgeMapper badgeMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDto mapUserToUserDto(User user) {
        UserDto.UserDtoBuilder userDto = UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .tokens(user.getTokens());

        if (user.getBadgeList() != null) {
            userDto.badgeList(user.getBadgeList().stream().map(b -> badgeMapper.mapBadgeToBadgeDto(b)).collect(Collectors.toList()));
        }
        return userDto.build();
    }

    public User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .tokens(100)
                .build();
    }

}