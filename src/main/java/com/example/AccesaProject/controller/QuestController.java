package com.example.AccesaProject.controller;

import com.example.AccesaProject.entity.security.SecurityUser;
import com.example.AccesaProject.payload.AnswerDto;
import com.example.AccesaProject.payload.ObjectResponse;
import com.example.AccesaProject.payload.QuestDto;
import com.example.AccesaProject.payload.UserDto;
import com.example.AccesaProject.service.AnswerService;
import com.example.AccesaProject.service.QuestService;
import com.example.AccesaProject.utils.AppConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quests")
@Slf4j
public class QuestController {
    private final QuestService questService;
    private final AnswerService answerService;

    public QuestController(QuestService questService, AnswerService answerService) {
        this.questService = questService;
        this.answerService = answerService;
    }

    @PostMapping
    public ResponseEntity<QuestDto> createQuest(@RequestBody QuestDto questDto, Authentication authentication) {
        log.info("QuestDto: {}",questDto);
        questDto.setUserDto(UserDto.builder()
                .id(((SecurityUser) authentication.getPrincipal()).getId())
                .build());
        return new ResponseEntity<>(questService.createQuest(questDto), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/answer")
    public ResponseEntity<AnswerDto> createAnswer(@RequestBody AnswerDto answerDto,
                                                  @PathVariable(name = "id") Long id, Authentication authentication) {
        log.info("AnswerDto: {}, questId = {}",answerDto,id);
        answerDto.setQuestDto(QuestDto.builder()
                .id(id)
                .build());

        answerDto.setUserDto(UserDto.builder()
                .id(((SecurityUser) authentication.getPrincipal()).getId())
                .build());

        return new ResponseEntity<>(answerService.createAnswer(answerDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestDto> getQuestById(@PathVariable Long id) {
        log.info("Get quest by id = {}",id);
        return new ResponseEntity<>(questService.getQuestById(id), HttpStatus.OK);
    }

    @GetMapping
    public ObjectResponse<QuestDto> getAllQuest(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        log.info("Pagination: pageNo = {}, pageSize = {}, sortBy = {}, sortDir = {}", pageNo, pageSize, sortBy, sortDir);
        return questService.getAllQuests(pageNo, pageSize, sortBy, sortDir);
    }

    @PutMapping("/{questId}/answer/{answerId}/pickWinner")
    public ResponseEntity<AnswerDto> pickWinner(@PathVariable(name = "questId") Long questId,
                                                @PathVariable(name = "answerId") Long answerId,
                                                Authentication authentication) {
        log.info("Id of the quest is {} and id of the answer is {}",questId,answerId);
        Long authId = ((SecurityUser) authentication.getPrincipal()).getId();
        return new ResponseEntity<>(questService.pickWinner(questId, answerId, authId), HttpStatus.OK);
    }

}