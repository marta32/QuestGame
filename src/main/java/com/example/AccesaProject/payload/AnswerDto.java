package com.example.AccesaProject.payload;

import com.example.AccesaProject.utils.AnswerStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerDto {
    private Long id;
    private UserDto userDto;
    private QuestDto questDto;
    @NotEmpty(message = "Quest response may not be empty.")
    private String questAnswer;
    private AnswerStatus status;
}