package com.example.AccesaProject.service.impl;

import com.example.AccesaProject.entity.Answer;
import com.example.AccesaProject.entity.Badge;
import com.example.AccesaProject.entity.Quest;
import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.exception.ActionNotAllowedException;
import com.example.AccesaProject.exception.NotEnoughTokensException;
import com.example.AccesaProject.exception.ResourceNotFoundException;
import com.example.AccesaProject.mapper.AnswerMapper;
import com.example.AccesaProject.mapper.QuestMapper;
import com.example.AccesaProject.payload.AnswerDto;
import com.example.AccesaProject.payload.ObjectResponse;
import com.example.AccesaProject.payload.QuestDto;
import com.example.AccesaProject.repository.AnswerRepository;
import com.example.AccesaProject.repository.BadgeRepository;
import com.example.AccesaProject.repository.QuestRepository;
import com.example.AccesaProject.repository.UserRepository;
import com.example.AccesaProject.service.BadgeService;
import com.example.AccesaProject.service.QuestService;
import com.example.AccesaProject.utils.AnswerStatus;
import com.example.AccesaProject.utils.BadgeCode;
import com.example.AccesaProject.utils.QuestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestServiceImpl implements QuestService {
    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestMapper questMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Autowired
    private BadgeRepository badgeRepository;
    @Autowired
    private BadgeService badgeService;

    @Override
    public QuestDto createQuest(QuestDto questDto) {
        Quest quest = questMapper.mapQuestDtoToQuest(questDto);
        User user = userRepository.findById(questDto.getUserDto().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", 0L));

        if (user.getTokens() >= questDto.getTokens()) {
            user.setTokens(user.getTokens() - questDto.getTokens());
        } else {
            throw new NotEnoughTokensException("You do not have enough tokens to create this quest");
        }
        badgeService.addBadge(user);

        quest.setProposedByUser(user);
        questRepository.save(quest);
        return questMapper.mapQuestToQuestDto(quest);
    }

    @Override
    public QuestDto getQuestById(Long id) {
        Quest quest = questRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quest", "id", id));
        return questMapper.mapQuestToQuestDto(quest);
    }

    @Override
    public ObjectResponse<QuestDto> getAllQuests(Integer pageNo, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Quest> quests = questRepository.findAll(pageable);

        List<Quest> listOfQuests = quests.getContent();

        List<QuestDto> newContent = listOfQuests.stream()
                .map(q -> questMapper.mapQuestToQuestDto(q)).collect(Collectors.toList());

        return ObjectResponse.<QuestDto>builder()
                .content(newContent)
                .pageNo(quests.getNumber())
                .pageSize(quests.getSize())
                .totalElements(quests.getTotalElements())
                .totalPages(quests.getTotalPages())
                .last(quests.isLast())
                .build();
    }

    @Override
    public AnswerDto pickWinner(Long questId, Long answerId, Long authId) {
        Answer answer = answerRepository.findById(answerId)
                .orElseThrow(() -> new ResourceNotFoundException("Answer", "id", answerId));
        Quest quest = answer.getQuest();
        User user =  answer.getUser();

        if(!quest.getProposedByUser().getId().equals(authId)){
            throw new ActionNotAllowedException("Action not allowed.");
        }

        if(quest.getStatus().equals(QuestStatus.OPEN)){
            answer.setStatus(AnswerStatus.WINNER);
            quest.setStatus(QuestStatus.CLOSED);
            user.setTokens(answer.getUser().getTokens() + quest.getTokens());
        }

        badgeService.addBadge(user);
        answerRepository.save(answer);
        return answerMapper.mapAnswerToAnswerDto(answer);
    }
}