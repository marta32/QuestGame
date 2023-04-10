package com.example.AccesaProject.controller;

import com.example.AccesaProject.payload.BadgeDto;
import com.example.AccesaProject.service.BadgeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badges")
public class BadgeController {
    private final BadgeService badgeService;

    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @PostMapping
    public ResponseEntity<BadgeDto> createBadge(@RequestBody BadgeDto badgeDto) {
        return new ResponseEntity<>(badgeService.createBadge(badgeDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BadgeDto>> getAllBadges() {
        return new ResponseEntity<>(badgeService.getAllBadges(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BadgeDto> getBadgeById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(badgeService.getBadgeById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BadgeDto> updateBadge(@RequestBody BadgeDto badgeDto,
                                                @PathVariable(name = "id") Long id) {
        BadgeDto badgeResponse = badgeService.updateBadge(badgeDto, id);
        return new ResponseEntity<>(badgeResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBadge(@PathVariable(name = "id") Long id) {
        badgeService.deleteBadgeById(id);
        return new ResponseEntity<>("Badge entity deleted successfully.", HttpStatus.OK);
    }
}
