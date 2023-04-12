package com.example.AccesaProject.payload;

import com.example.AccesaProject.utils.BadgeCode;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BadgeDto {
    private Long id;
    @NotEmpty(message = "Name of badge may not be empty.")
    private String name;
    @NotEmpty(message = "BadgeCode of badge may not be empty.")
    private BadgeCode badgeCode;

}