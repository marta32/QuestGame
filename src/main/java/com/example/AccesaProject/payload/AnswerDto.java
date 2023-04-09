package com.example.AccesaProject.payload;

import com.example.AccesaProject.utils.AnswerStatus;
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
    private UserDto userDto;
    private QuestDto questDto;
    private String questAnswer;
    private AnswerStatus status;
}