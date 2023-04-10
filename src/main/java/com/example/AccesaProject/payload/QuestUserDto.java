package com.example.AccesaProject.payload;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class QuestUserDto {
    private Long id;
    private String quest;
    private String answear;
    private Integer tokens;
    private String status;

}
