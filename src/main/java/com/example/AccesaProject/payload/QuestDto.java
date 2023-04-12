package com.example.AccesaProject.payload;

import com.example.AccesaProject.utils.QuestStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestDto {
    private Long id;
    @NotEmpty(message = "Quest may not be empty")
    private String quest;
    @NotNull(message = "Quest may not be without tokens")
    private Integer tokens;
    private QuestStatus status;
    private UserDto userDto;
    private List<AnswerDto> answers;

}