package com.example.AccesaProject.payload;

import com.example.AccesaProject.utils.BadgeCode;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BadgeDto {
    private Long id;
    private String name;
    private BadgeCode badgeCode;
}

