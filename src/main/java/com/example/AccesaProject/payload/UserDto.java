package com.example.AccesaProject.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;
    private String name;
    private Integer tokens;
    private List<QuestUserDto> proposedQuests;
    private List<AnswerDto> resolvedQuests;
    private List<BadgeDto> badgeList;

}
