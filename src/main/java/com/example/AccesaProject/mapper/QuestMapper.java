package com.example.AccesaProject.mapper;

import com.example.AccesaProject.entity.Quest;
import com.example.AccesaProject.payload.QuestDto;
import com.example.AccesaProject.payload.UserQuestDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class QuestMapper {
    public QuestDto mapQuestToQuestDto(Quest quest) {
//        QuestDto.QuestDtoBuilder questDto = QuestDto.builder()
//                .id(quest.getId())
//                .userId(quest.getUserId())
//                .quest(quest.getQuest())
//                .answear(quest.getAnswear())
//                .tokens(quest.getTokens())
//                .status(quest.getStatus());
//
//        if(quest.getUserList() != null){
//            questDto.userList(quest.getUserList().stream()
//                    .map(u-> UserQuestDto.builder()
//                            .id(u.getId())
//                            .username(u.getUsername())
//                            .tokens(u.getTokens())
//                            .password(u.getPassword())
//                            .build())
//                    .collect(Collectors.toList()));
//        }
//        return questDto.build();
        return null;
    }

    public Quest mapQuestDtoToQuest(QuestDto questDto){
        return Quest.builder()
//                .userId(questDto.getUserId())
                .quest(questDto.getQuest())
//                .answear(questDto.getAnswear())
                .tokens(questDto.getTokens())
                .status(questDto.getStatus())
                .build();
    }

}