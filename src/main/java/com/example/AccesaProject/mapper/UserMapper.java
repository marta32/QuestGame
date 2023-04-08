package com.example.AccesaProject.mapper;

import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.payload.BadgeDto;
import com.example.AccesaProject.payload.QuestUserDto;
import com.example.AccesaProject.payload.UserDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto mapUserToUserDto(User user) {
        UserDto.UserDtoBuilder userDto = UserDto.builder()
                .id(user.getId())
                .name(user.getName())
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
                .name(userDto.getName())
                .tokens(100)
                .build();
    }

}