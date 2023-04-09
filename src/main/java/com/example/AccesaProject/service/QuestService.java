package com.example.AccesaProject.service;

import com.example.AccesaProject.payload.AnswerDto;
import com.example.AccesaProject.payload.ObjectResponse;
import com.example.AccesaProject.payload.QuestDto;

public interface QuestService {
    QuestDto createQuest(QuestDto questDto);
    QuestDto getQuestById(Integer id);
    ObjectResponse<QuestDto> getAllQuests(Integer pageNo, Integer pageSize, String sortBy, String sortDir);
    AnswerDto pickWinner(Integer questId, Integer answerId);
}
