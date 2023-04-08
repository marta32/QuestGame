package com.example.AccesaProject.mapper;

import com.example.AccesaProject.entity.Badge;
import com.example.AccesaProject.payload.BadgeDto;
import org.springframework.stereotype.Component;

@Component
public class BadgeMapper {
    public BadgeDto mapBadgeToBadgeDto(Badge badge){
        return BadgeDto.builder()
                .id(badge.getId())
                .name(badge.getName())
                .build();
    }

    public Badge mapBadgeDtoToBadge(BadgeDto badgeDto){
        return Badge.builder()
                .name(badgeDto.getName())
                .build();
    }

}
