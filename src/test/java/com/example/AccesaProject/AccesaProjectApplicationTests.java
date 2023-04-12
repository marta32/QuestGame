package com.example.AccesaProject;

import com.example.AccesaProject.entity.Answer;
import com.example.AccesaProject.entity.Badge;
import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.payload.UserDto;
import com.example.AccesaProject.repository.AnswerRepository;
import com.example.AccesaProject.repository.BadgeRepository;
import com.example.AccesaProject.repository.UserRepository;
import com.example.AccesaProject.service.BadgeService;
import com.example.AccesaProject.service.QuestService;
import com.example.AccesaProject.service.UserService;
import com.example.AccesaProject.utils.AnswerStatus;
import com.example.AccesaProject.utils.BadgeCode;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccesaProjectApplication.class)
class AccesaProjectApplicationTests {
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private AnswerRepository answerRepository;
    @Autowired
    private QuestService questService;
    @Autowired
    private UserService userService;
    @MockBean
    private BadgeRepository badgeRepository;
    @Autowired
    private BadgeService badgeService;

    @Test
    public void testCreateUser() {

        // given
        UserDto userDtoRequest = UserDto.builder()
                .username("marta")
                .password("marta23")
                .build();

        User user = User.builder()
                .id(10L)
                .username("marta")
                .tokens(100)
                .password("marta23")
                .build();

        UserDto userDtoExpectedResponse = UserDto.builder()
                .username("marta")
                .tokens(100)
                .id(10L)
                .build();

        // when
        Mockito.when(userRepository.save(any())).thenReturn(user);
        UserDto actualResponse = userService.createUser(userDtoRequest);

        // then
        Assert.assertEquals(actualResponse, userDtoExpectedResponse);
    }

    @Test
    public void testAddBadge() {
        // given

        Answer answer1 = Answer.builder()
                .status(AnswerStatus.WINNER)
                .build();

        Answer answer2 = Answer.builder()
                .status(AnswerStatus.WINNER)
                .build();

        User user = User.builder()
                .id(10L)
                .tokens(100)
                .answerList(List.of(answer1, answer2))
                .badgeList(new ArrayList<>())
                .proposedQuests(List.of())
                .build();

        Badge badge = Badge.builder()
                .badgeCode(BadgeCode.WIN3)
                .build();

        User userExpected = User.builder()
                .id(10L)
                .tokens(100)
                .answerList(List.of(answer1, answer2))
                .badgeList(List.of(badge))
                .proposedQuests(List.of())
                .build();

        // when
        Mockito.when(badgeRepository.findBadgeByBadgeCode(any())).thenReturn(badge);
        User userActual = badgeService.addBadge(user);

        // then
        Assert.assertEquals(userActual, userExpected);
    }

}