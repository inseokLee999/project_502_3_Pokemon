package org.choongang.member.services;

import lombok.RequiredArgsConstructor;
import org.choongang.member.controllers.LoginRequest;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.validators.LoginValidator;

@RequiredArgsConstructor
public class TestLoginService {
    private final LoginValidator validator;
    private final MemberMapper mapper;

    public void process(LoginRequest form) {
        //로그인 유효성 검사
        validator.check(form);
         //테스트 이므로 세션 존재 X
        //로그인 처리 - 회원 정보 조회, 세션에 유지
        /*String email = form.getEmail();
        Member member = mapper.get(email);
        HttpSession session = BeanContainer.getInstance().getBean(HttpSession.class);
        session.setAttribute("member", member);*/
    }
}
