package com.example.AccesaProject.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;
    private String username;
    private Integer tokens;
    private String password;
//    private List<QuestUserDto> proposedQuests;
//    private List<QuestUserDto> resolvedQuests;
//    private List<BudgeUserDto> badgeList;

}
