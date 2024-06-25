package org.choongang.member.validators;

import org.choongang.member.controllers.LoginRequest;
import org.choongang.member.mapper.MemberMapper;

public class LoginValidator implements Validator<LoginRequest>, RequiredValidator, EmailValidator{

    private MemberMapper mapper;


    @Override
    public void check(LoginRequest form) {
        String email = form.getEmail();
        String password = form.getPassword();
    }
}
