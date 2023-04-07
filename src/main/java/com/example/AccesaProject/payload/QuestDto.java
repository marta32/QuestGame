package com.example.AccesaProject.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestDto {
    private Integer id;
    private String quest;
    private String answear;
    private Integer tokens;
    private String status;
    private List<UserQuestDto> userList;

}
