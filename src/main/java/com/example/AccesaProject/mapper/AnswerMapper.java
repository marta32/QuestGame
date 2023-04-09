package com.example.AccesaProject.mapper;

import com.example.AccesaProject.entity.Answer;
import com.example.AccesaProject.entity.Quest;
import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.payload.AnswerDto;
import com.example.AccesaProject.payload.QuestDto;
import com.example.AccesaProject.payload.UserDto;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {

    public Answer mapAnswerDtoToAnswer(AnswerDto answerDto){
        return Answer.builder()
                .id(answerDto.getId())
                .questAnswer(answerDto.getQuestAnswer())
                .status(answerDto.getStatus())
                .user(User.builder()
                        .username(answerDto.getUserDto().getUsername())
                        .build())
                .quest(Quest.builder()
                        .quest(answerDto.getQuestDto().getQuest())
                        .build())
                .build();
    }

    public AnswerDto mapAnswerToAnswerDto(Answer answer){
        return AnswerDto.builder()
                .id(answer.getId())
                .questAnswer(answer.getQuestAnswer())
                .status(answer.getStatus())
                .userDto(UserDto.builder()
                        .id(answer.getUser().getId())
                        .username(answer.getUser().getUsername())
                        .build())
                .questDto(QuestDto.builder()
                        .id(answer.getId())
                        .quest(answer.getQuest().getQuest())
                        .build())
                .build();
    }
}