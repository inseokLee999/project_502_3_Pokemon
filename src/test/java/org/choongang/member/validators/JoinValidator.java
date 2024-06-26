package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.validators.EmailValidator;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.mapper.MemberMapper;

public class JoinValidator implements Validator<RequestJoin>, RequiredValidator, EmailValidator {



    @Override
    public void check(RequestJoin form) {
        /* 필수 항목 검증 - 이메일, 비밀번호, 비밀번호 확인, 회원명, 약관 동의 */
        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String userName = form.getUserName();
        boolean termsAgree = form.isTermsAgree();
        int status = HttpServletResponse.SC_BAD_REQUEST;

        /* 필수 항목 유효성 검사 S */

    }
}
