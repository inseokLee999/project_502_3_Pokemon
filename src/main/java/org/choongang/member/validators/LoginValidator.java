package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.global.exceptions.AlertException;
import org.choongang.global.validators.EmailValidator;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.LoginRequest;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.mindrot.jbcrypt.BCrypt;

@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator<LoginRequest>, RequiredValidator, EmailValidator {

    private final MemberMapper mapper;


    @Override
    public void check(LoginRequest form) {
        //필수 항목 검증
        String email = form.getEmail();
        String password = form.getPassword();

        int status = HttpServletResponse.SC_BAD_REQUEST;

        // 필수 항목 유효성 검사
        checkRequired(email, new AlertException("이메일을 입력하세요.", status));
        checkRequired(password, new AlertException("비밀번호를 입력하세요.", status));

        // 아이디, 비번 불일치 시 오류 메세지-> message
        String message = "이메일 또는 비밀번호가 일치하지 않습니다.";
        Member member = mapper.get(email);
        System.out.println(member);
        checkTrue(member != null, new AlertException(message, status));

        checkTrue(BCrypt.checkpw(password, member.getPassword()), new AlertException(message, status));

    }

}
