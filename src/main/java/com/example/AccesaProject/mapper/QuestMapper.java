package com.example.AccesaProject.mapper;

import com.example.AccesaProject.entity.Quest;
import com.example.AccesaProject.payload.AnswerDto;
import com.example.AccesaProject.payload.QuestDto;
import com.example.AccesaProject.payload.UserDto;
import com.example.AccesaProject.utils.QuestStatus;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class QuestMapper {
    public QuestDto mapQuestToQuestDto(Quest quest) {
        QuestDto.QuestDtoBuilder questDto = QuestDto.builder()
                .id(quest.getId())
                .quest(quest.getQuest())
                .tokens(quest.getTokens())
                .status(quest.getStatus())
                .userDto(UserDto.builder()
                        .id(quest.getProposedByUser().getId())
                        .username(quest.getProposedByUser().getUsername())
                        .build());
        if(quest.getAnswerList() != null){
            questDto.answers(quest.getAnswerList().stream()
                    .map( a -> AnswerDto.builder()
                            .id(a.getId())
                            .questAnswer(a.getQuestAnswer())
                            .status(a.getStatus())
                            .userDto(UserDto.builder()
                                    .id(a.getUser().getId())
                                    .username(a.getUser().getUsername())
                                    .build())
                            .build())
                    .collect(Collectors.toList()));
        }

        return questDto.build();
    }

    public Quest mapQuestDtoToQuest(QuestDto questDto){
        return Quest.builder()
                .quest(questDto.getQuest())
                .tokens(questDto.getTokens())
                .status(QuestStatus.OPEN)
                .build();
    }

}