package com.example.AccesaProject.controller;

import com.example.AccesaProject.payload.QuestDto;
import com.example.AccesaProject.service.QuestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quests")
public class QuestController {
    private final QuestService questService;

    public QuestController(QuestService questService) {
        this.questService = questService;
    }
    @PostMapping
    public ResponseEntity<QuestDto> createQuest(@RequestBody QuestDto questDto){
        return new ResponseEntity<>(questService.createQuest(questDto), HttpStatus.CREATED);
    }


}