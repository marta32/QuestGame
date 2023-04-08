package com.example.AccesaProject.service;

import com.example.AccesaProject.payload.BadgeDto;

import java.util.List;

public interface BadgeService {
    BadgeDto createBadge(BadgeDto badgeDto);
    List<BadgeDto> getAllBadges();
    BadgeDto getBadgeById(Integer id);
    BadgeDto updateBadge(BadgeDto badgeDto, Integer id);
    void deleteBadgeById(Integer id);

}
