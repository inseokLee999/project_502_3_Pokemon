package org.choongang.member.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.services.LoginService;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String login() {

        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs(LoginRequest form) {
        loginService.process(form);

        return "member/login";
    }
}
