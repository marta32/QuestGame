package com.example.AccesaProject.controller;

import com.example.AccesaProject.payload.BadgeDto;
import com.example.AccesaProject.service.BadgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badges")
@Slf4j
public class BadgeController {
    private final BadgeService badgeService;

    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @PostMapping
    public ResponseEntity<BadgeDto> createBadge(@RequestBody BadgeDto badgeDto) {
        log.info("BadgeDto: {}",badgeDto);
        return new ResponseEntity<>(badgeService.createBadge(badgeDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BadgeDto>> getAllBadges() {
        log.info("Get all badges!");
        return new ResponseEntity<>(badgeService.getAllBadges(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BadgeDto> getBadgeById(@PathVariable(name = "id") Long id) {
        log.info("Get badge with id = {}",id);
        return new ResponseEntity<>(badgeService.getBadgeById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BadgeDto> updateBadge(@RequestBody BadgeDto badgeDto,
                                                @PathVariable(name = "id") Long id) {
        log.info("New badgeDto: {} , idOfChangedBadge = {}",badgeDto,id);
        BadgeDto badgeResponse = badgeService.updateBadge(badgeDto, id);
        return new ResponseEntity<>(badgeResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBadge(@PathVariable(name = "id") Long id) {
        log.info("The badge with id = {} is deleted.", id);
        badgeService.deleteBadgeById(id);
        return new ResponseEntity<>("Badge entity deleted successfully.", HttpStatus.OK);
    }
}
