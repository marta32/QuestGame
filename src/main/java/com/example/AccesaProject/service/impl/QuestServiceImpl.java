package com.example.AccesaProject.service.impl;

import com.example.AccesaProject.entity.Quest;
import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.exception.ResourceNotFoundException;
import com.example.AccesaProject.mapper.QuestMapper;
import com.example.AccesaProject.payload.QuestDto;
import com.example.AccesaProject.repository.QuestRepository;
import com.example.AccesaProject.repository.UserRepository;
import com.example.AccesaProject.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestServiceImpl implements QuestService {
    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestMapper questMapper;
    @Override
    public QuestDto createQuest(QuestDto questDto) {
        Quest quest = questMapper.mapQuestDtoToQuest(questDto);
        User user = userRepository.findById(questDto.getUserDto().getId())
                .orElseThrow(()-> new ResourceNotFoundException("User", "id", 0L));

        // todo add validation if user has at least questDto.getTokens()
        user.setTokens(user.getTokens() - questDto.getTokens());

        quest.setProposedByUser(user);

        questRepository.save(quest);
        return questMapper.mapQuestToQuestDto(quest);
    }
}
