package com.example.AccesaProject.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(exclude = "password")
@EqualsAndHashCode
public class UserDto {
    private Long id;
    @NotEmpty(message = "Username may not be empty")
    private String username;
    @NotEmpty(message = "Password may not be empty")
    private String password;
    private Integer tokens;
    private List<QuestDto> proposedQuests;
    private List<AnswerDto> resolvedQuests;
    private List<BadgeDto> badgeList;

}