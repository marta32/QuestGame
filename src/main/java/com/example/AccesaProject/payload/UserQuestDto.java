package com.example.AccesaProject.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserQuestDto {

    private Integer id;
    private String username;
    private Integer tokens;
    private String password;
}
