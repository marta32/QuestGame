package com.example.AccesaProject.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserQuestDto {

    private Long id;
    private String username;
    private Integer tokens;
}
