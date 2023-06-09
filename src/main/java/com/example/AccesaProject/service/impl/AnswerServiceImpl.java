package com.example.AccesaProject.service.impl;

import com.example.AccesaProject.entity.Answer;
import com.example.AccesaProject.entity.Quest;
import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.exception.ActionNotAllowedException;
import com.example.AccesaProject.exception.ResourceNotFoundException;
import com.example.AccesaProject.mapper.AnswerMapper;
import com.example.AccesaProject.payload.AnswerDto;
import com.example.AccesaProject.repository.AnswerRepository;
import com.example.AccesaProject.repository.QuestRepository;
import com.example.AccesaProject.repository.UserRepository;
import com.example.AccesaProject.service.AnswerService;
import com.example.AccesaProject.utils.AnswerStatus;
import com.example.AccesaProject.utils.QuestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public AnswerDto createAnswer(AnswerDto answerDto) {
        User user = userRepository.findById(answerDto.getUserDto().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", answerDto.getUserDto().getId()));

        Quest quest = questRepository.findById(answerDto.getQuestDto().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Quest", "id", answerDto.getQuestDto().getId()));

        if (quest.getStatus().equals(QuestStatus.CLOSED)) {
            throw new ActionNotAllowedException("The quest is closed.");
        }

        Answer answer = Answer.builder()
                .quest(quest)
                .user(user)
                .status(AnswerStatus.PROPOSED)
                .questAnswer(answerDto.getQuestAnswer())
                .build();

        answerRepository.save(answer);

        return AnswerDto.builder()
                .id(answer.getId())
                .questAnswer(answer.getQuestAnswer())
                .build();
    }

}