package org.choongang.member.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
    private final HttpServletRequest request;
    private final HttpServletResponse response;


    private final LoginService loginService;

    @GetMapping("/login")
    public String login() {
        request.setAttribute("addCss", new String[] {"member/loginStyle"});
        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs(LoginRequest form) {

        loginService.process(form);

        Cookie cookie = new Cookie("saveEmail", form.getEmail());
        if (form.isSaveEmail()) {
            cookie.setMaxAge(60*60*24*7);
        } else {
            cookie.setMaxAge(0);
        } response.addCookie(cookie);

        String redirectUrl = form.getRedirectUrl();
        redirectUrl = redirectUrl == null || redirectUrl.isBlank() ? "/" : redirectUrl;

        String script = String.format("parent.location.replace('%s');", request.getContextPath() + redirectUrl);

        request.setAttribute("script", script);

        return "commons/execute_script";
    }
}
