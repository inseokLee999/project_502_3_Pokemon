package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class LogoutController {

    private final HttpServletRequest request;

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 비우기 : 로그아웃
        /*
        String redirectUrl = "/member/logout";

        redirectUrl = redirectUrl == null || redirectUrl.isBlank() ? "/" : redirectUrl;

        String script = String.format("parent.location.replace('%s');", request.getContextPath() + redirectUrl);

        request.setAttribute("script", script);

        return "commons/execute_script";
        */
        return "member/logout";
    }
}
