package org.choongang.member.tests;

import com.github.javafaker.Faker;
import jakarta.servlet.http.HttpSession;
import org.choongang.global.config.DBConn;
import org.choongang.global.exceptions.AlertException;
import org.choongang.member.controllers.JoinRequest;
import org.choongang.member.controllers.LoginRequest;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.JoinValidator;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.only;


@ExtendWith(MockitoExtension.class)
@DisplayName("로그인 기능 테스트")
public class LoginServiceTest {

    private LoginService loginService;
    private Faker faker;
    private LoginRequest form;
    private JoinRequest joinForm;

    @Mock
    private HttpSession session;

    //private HttpServletRequest request;

    @BeforeEach
    void init() {
        faker = new Faker(Locale.ENGLISH);

        MemberMapper mapper = DBConn.getSession().getMapper(MemberMapper.class);
        JoinValidator v = new JoinValidator(mapper);
        JoinService joinService = new JoinService(v, mapper);
        joinForm = JoinRequest.builder()
                .email(System.currentTimeMillis() + faker.internet().emailAddress())
                .password(faker.regexify("\\w{8,16}").toLowerCase())
                .termsAgree(true)
                .userName(faker.name().fullName())
                .build();
        joinForm.setConfirmPassword(joinForm.getPassword());

        joinService.process(joinForm);

        LoginValidator validator = new LoginValidator(mapper);
        loginService = new LoginService(validator, mapper);

        faker = new Faker(Locale.ENGLISH);

        form = getData();

    }

    LoginRequest getData() {
        LoginRequest form = new LoginRequest();
        form.setEmail(joinForm.getEmail());
        form.setPassword(joinForm.getPassword());

        return form;
    }


    @Test
    @DisplayName("로그인 성공 시 예외가 발생하지 않음")
    void successTest() {
        assertDoesNotThrow(()-> {
            loginService.process(getData());
        });

        // 로그인 처리 완료시 HttpSession - setAttribute 메서드가 호출 됨 -> 로그인 다 되면 구현
        then(session).should(only()).setAttribute(any(), any());

    }

    @Test
    @DisplayName("필수 입력 항목(이메일, 비밀번호) 검증, 검증 실패 시 BadRequestException 발생")
    void requiredFieldTest() {
        assertAll(
                ()-> requiredEachFieldTest("email", false, "이메일을 입력"),
                ()-> requiredEachFieldTest("email", true, "이메일을 입력"),
                ()-> requiredEachFieldTest("password", false, "비밀번호를 입력"),
                ()-> requiredEachFieldTest("password", true, "비밀번호를 입력")
        );
    }

    void requiredEachFieldTest(String name, boolean isNull, String message) {

        form = getData();
        AlertException thrown = assertThrows(AlertException.class, () -> {
            if (!name.equals("password")) {
               form.setEmail(isNull ? null : "    ");
            } else { //이메일
                form.setPassword(isNull ? null : "    ");
            }
            loginService.process(form);
        }, name + " 테스트");

        String msg = thrown.getMessage();
        System.out.println("msg:"+msg);
        System.out.println("messsage:"+message);
        System.out.println(msg.contains(message));
        assertTrue(msg.contains(message), name + ", 키워드:" + message);
    }


    @Test
    @DisplayName("이메일로 회원이 조회 되는지 검증, 검증 실패시 BadRequestException 발생")
    void memberExistTest() {
        form.setEmail("***" + getData().getEmail());

        AlertException thrown = assertThrows(AlertException.class, () -> {
            loginService.process(form);
        });

        String message = thrown.getMessage();
        System.out.println(message);
        assertTrue(message.contains("이메일 또는 비밀번호가 일치"));
    }

    @Test
    @DisplayName("비밀번호 검증, 실패 시 BadRequestException 발생")
    void passwordCheckTest() {
        form.setPassword("***" + getData().getPassword());

        AlertException thrown = assertThrows(AlertException.class, () -> {
            loginService.process(form);
        });

        String message = thrown.getMessage();
        assertTrue(message.contains("이메일 또는 비밀번호가 일치"));
    }

    @AfterEach
    void destroy() {
        //dbSession.rollback();
    }
}



