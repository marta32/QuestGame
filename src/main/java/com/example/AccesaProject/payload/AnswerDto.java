package com.example.AccesaProject.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerDto {
    private Integer id;
    private UserDto user;
    private QuestDto quest;
    private String questAnswer;
}