package com.example.AccesaProject.repository;

import com.example.AccesaProject.entity.Badge;
import com.example.AccesaProject.utils.BadgeCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
    Badge findBadgeByBadgeCode(BadgeCode badgeCode);

}