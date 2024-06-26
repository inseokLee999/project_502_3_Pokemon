package org.choongang.member.tests;

import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpSession;
import org.choongang.global.config.DBConn;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.controllers.LoginRequest;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.LoginValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
@DisplayName("로그인 기능 테스트")
public class LoginServiceTest {

    private LoginService loginService;
    private Faker faker;

    @Mock
    private HttpSession session;


    //private HttpServletRequest request;

    @BeforeEach
    void init() {


        MemberMapper mapper = DBConn.getSession().getMapper(MemberMapper.class);

        LoginValidator validator = new LoginValidator(mapper);
        loginService = new LoginService(validator, mapper, session);

        faker = new Faker(Locale.ENGLISH);


    }

    LoginRequest getData() {
        LoginRequest form = new LoginRequest();
        form.setEmail(System.currentTimeMillis() + faker.internet().emailAddress());
        form.setPassword(faker.regexify("\\w{8}").toLowerCase());

        return form;
    }


    @Test
    @DisplayName("로그인 성공 시 예외가 발생하지 않음")
    void successTest() {
        assertDoesNotThrow(()-> {
            loginService.process(getData());
        });

        // 로그인 처리 완료시 HttpSession - setAttribute 메서드가 호출 됨 -> 로그인 다 되면 구현
        // then(session).should(only()).setAttribute(any(), any());

    }

    @Test
    @DisplayName("필수 입력 항목(이메일, 비밀번호) 검증, 검증 실패 시 BadRequestException 발생")
    void requiredFieldTest() {
        assertAll(
                ()-> requiredEachFieldTest("email", false, "이메일"),
                ()-> requiredEachFieldTest("email", true, "이메일"),
                ()-> requiredEachFieldTest("password", false, "비밀번호"),
                ()-> requiredEachFieldTest("password", true, "비밀번호")
        );
    }

    void requiredEachFieldTest(String name, boolean isNull, String message) {
       LoginRequest form = getData();

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            if (name.equals("password")) {
               form.setEmail(isNull ? null : "    ");
            } else { //이메일
                form.setPassword(isNull ? null : "    ");
            }
            loginService.process(form);
        }, name + " 테스트");

        String msg = thrown.getMessage();
        assertTrue(msg.contains(message), name + ", 키워드:" + message);
    }


    @Test
    @DisplayName("이메일로 회원이 조회 되는지 검증, 검증 실패시 BadRequestException 발생")
    void memberExistTest() {
        LoginRequest form = new LoginRequest();
        form.setEmail("***" + getData().getEmail());

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            loginService.process(form);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("이메일 또는 비밀번호"));
    }

    @Test
    @DisplayName("비밀번호 검증, 실패 시 BadRequestException 발생")
    void passwordCheckTest() {
        LoginRequest form = new LoginRequest();
        form.setPassword("***" + getData().getPassword());

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> {
            loginService.process(form);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("이메일 또는 비밀번호"));
    }

    @AfterEach
    void destroy() {
        //dbSession.rollback();
    }
}



