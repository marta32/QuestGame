package com.example.AccesaProject.service;

import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.payload.BadgeDto;

import java.util.List;

public interface BadgeService {
    BadgeDto createBadge(BadgeDto badgeDto);
    void addBadge(User user);
    List<BadgeDto> getAllBadges();
    BadgeDto getBadgeById(Long id);
    BadgeDto updateBadge(BadgeDto badgeDto, Long id);
    void deleteBadgeById(Long id);

}
