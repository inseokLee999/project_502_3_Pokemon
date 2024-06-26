package org.choongang.member.validators;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.global.validators.EmailValidator;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.LoginRequest;
import org.choongang.member.mapper.MemberMapper;

@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator<LoginRequest>, RequiredValidator, EmailValidator {

    private final MemberMapper mapper;


    @Override
    public void check(LoginRequest form) {
        String email = form.getEmail();
        String password = form.getPassword();

    }


}
