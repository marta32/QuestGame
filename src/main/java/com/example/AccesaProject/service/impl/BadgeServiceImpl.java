package com.example.AccesaProject.service.impl;

import com.example.AccesaProject.entity.Answer;
import com.example.AccesaProject.entity.Badge;
import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.exception.ResourceNotFoundException;
import com.example.AccesaProject.mapper.BadgeMapper;
import com.example.AccesaProject.payload.BadgeDto;
import com.example.AccesaProject.repository.BadgeRepository;
import com.example.AccesaProject.service.BadgeService;
import com.example.AccesaProject.utils.AnswerStatus;
import com.example.AccesaProject.utils.BadgeCode;
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
        badge = badgeRepository.save(badge);
        return badgeMapper.mapBadgeToBadgeDto(badge);
    }

    @Override
    public void addBadge(User user) {

        long countWin = user.getAnswerList().stream()
                .filter(a -> a.getStatus().equals(AnswerStatus.WINNER))
                .count();

        if (countWin == 2) {
            long found = user.getBadgeList().stream()
                    .filter(b -> b.getBadgeCode().equals(BadgeCode.WIN3))
                    .count();
            if (found == 0) {
                Badge badge = badgeRepository.findBadgeByBadgeCode(BadgeCode.WIN3);
                user.getBadgeList().add(badge);
            }
        }

        if (user.getProposedQuests().size() == 4) {
            long found = user.getBadgeList().stream()
                    .filter(b -> b.getBadgeCode().equals(BadgeCode.QUESTS5))
                    .count();
            if (found == 0) {
                Badge badge = badgeRepository.findBadgeByBadgeCode(BadgeCode.QUESTS5);
                user.getBadgeList().add(badge);
            }
        }

        if (user.getTokens() > 250) {
            long found = user.getBadgeList().stream()
                    .filter(b -> b.getBadgeCode().equals(BadgeCode.TOKENS250))
                    .count();
            if (found == 0) {
                Badge badge = badgeRepository.findBadgeByBadgeCode(BadgeCode.TOKENS250);
                user.getBadgeList().add(badge);
            }
        }

    }

    @Override
    public List<BadgeDto> getAllBadges() {
        return badgeRepository.findAll().stream()
                .map(b -> badgeMapper.mapBadgeToBadgeDto(b))
                .collect(Collectors.toList());
    }

    @Override
    public BadgeDto getBadgeById(Long id) {
        Badge badge = badgeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Badge", "id", id));
        return badgeMapper.mapBadgeToBadgeDto(badge);
    }


    @Override
    public BadgeDto updateBadge(BadgeDto badgeDto, Long id) {
        Badge badge = badgeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Badge", "id", id));
        badge.setName(badgeDto.getName());
        Badge updateBadge = badgeRepository.save(badge);
        return badgeMapper.mapBadgeToBadgeDto(updateBadge);
    }

    @Override
    public void deleteBadgeById(Long id) {
        Badge badge = badgeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Badge", "id", id));
        badgeRepository.delete(badge);
    }
}