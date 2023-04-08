package com.example.AccesaProject.mapper;

import com.example.AccesaProject.entity.Badge;
import com.example.AccesaProject.payload.BadgeDto;

public class BadgeMapper {
    public BadgeDto mapBageToBadgeDto(Badge badge){
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
