package com.example.AccesaProject.service;

import com.example.AccesaProject.payload.AnswerDto;
import com.example.AccesaProject.payload.ObjectResponse;
import com.example.AccesaProject.payload.QuestDto;

public interface QuestService {
    QuestDto createQuest(QuestDto questDto);

    QuestDto getQuestById(Long id);

    ObjectResponse<QuestDto> getAllQuests(Integer pageNo, Integer pageSize, String sortBy, String sortDir);

    AnswerDto pickWinner(Long questId, Long answerId, Long authId);

}