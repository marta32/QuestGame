package com.example.AccesaProject.service.impl;

import com.example.AccesaProject.entity.Badge;
import com.example.AccesaProject.exception.ResourceNotFoundException;
import com.example.AccesaProject.mapper.BadgeMapper;
import com.example.AccesaProject.payload.BadgeDto;
import com.example.AccesaProject.repository.BadgeRepository;
import com.example.AccesaProject.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BadgeServiceImpl implements BadgeService {
    @Autowired
    private BadgeRepository badgeRepository;
    @Autowired
    private BadgeMapper badgeMapper;

    @Override
    public BadgeDto createBadge(BadgeDto badgeDto) {
        Badge badge = badgeMapper.mapBadgeDtoToBadge(badgeDto);
        badgeRepository.save(badge);
        return badgeMapper.mapBadgeToBadgeDto(badge);
    }

    @Override
    public List<BadgeDto> getAllBadges() {
        return badgeRepository.findAll().stream()
                .map(b -> badgeMapper.mapBadgeToBadgeDto(b))
                .collect(Collectors.toList());
    }

    @Override
    public BadgeDto getBadgeById(Integer id) {
        Badge badge = badgeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Badge", "id", id));
        return badgeMapper.mapBadgeToBadgeDto(badge);
    }

    @Override
    public BadgeDto updateBadge(BadgeDto badgeDto, Integer id) {
        Badge badge = badgeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Badge","id",id));
        badge.setName(badgeDto.getName());
        Badge updateBadge = badgeRepository.save(badge);
        return badgeMapper.mapBadgeToBadgeDto(updateBadge);
    }

    @Override
    public void deleteBadgeById(Integer id) {
        Badge badge = badgeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Badge","id",id));
        badgeRepository.delete(badge);
    }
}
