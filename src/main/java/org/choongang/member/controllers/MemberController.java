package org.choongang.member.controllers;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

    // 회원 가입 양식
    @GetMapping("/join")
    public String join() {

        return "member/join";
    }

    // 회원 가입 처리
    @PostMapping("/join")
    public String joinPost() {

        return null;
    }
}
