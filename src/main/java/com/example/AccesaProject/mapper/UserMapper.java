package com.example.AccesaProject.mapper;

import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.payload.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserDto mapUserToUserDto(User user) {
        UserDto.UserDtoBuilder userDto = UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .tokens(user.getTokens());

//        if (user.getProposedQuests() != null) {
//            userDto.proposedQuests(user.getProposedQuests().stream()
//                    .map(q -> QuestUserDto.builder()
//                            .id(q.getId())
//                            .quest(q.getQuest())
//                            .tokens(q.getTokens())
//                            .status(q.getStatus())
//                            .build())
//                    .collect(Collectors.toList()));
//        }

//        if (user.getResolvedQuests() != null) {
//            userDto.resolvedQuests(user.getResolvedQuests().stream()
//                    .map(q -> QuestUserDto.builder()
//                            .id(q.getId())
//                            .quest(q.getQuest())
//                            .answear(q.getAnswear())
//                            .tokens(q.getTokens())
//                            .status(q.getStatus())
//                            .build())
//                    .collect(Collectors.toList()));
//        }
//        if (user.getBadgeList() != null){
//            userDto.badgeList(user.getBadgeList().stream()
//                    .map(b -> BadgeDto.builder()
//                            .id(b.getId())
//                            .name(b.getName())
//                            .build())
//                    .collect(Collectors.toList()));
//        }
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