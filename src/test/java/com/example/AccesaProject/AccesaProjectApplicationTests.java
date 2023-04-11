package com.example.AccesaProject;

import com.example.AccesaProject.entity.Answer;
import com.example.AccesaProject.entity.User;
import com.example.AccesaProject.payload.UserDto;
import com.example.AccesaProject.repository.AnswerRepository;
import com.example.AccesaProject.repository.UserRepository;
import com.example.AccesaProject.service.QuestService;
import com.example.AccesaProject.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

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

    public void testPickWinner() {
		// given
//		Answer answer = Answer.builder()
//				.id(25L)
//				.user(User.builder()
//						.id(5L)
//						.username("cleo")
//						.password("cleo23")
//						.tokens(145)
//						.proposedQuests(null)
//						.badgeList(null)
//						.build())
//				.build();
//		// when
//		Mockito.when(answerRepository.save(any())).thenReturn(answer);
//		// then
    }


}
