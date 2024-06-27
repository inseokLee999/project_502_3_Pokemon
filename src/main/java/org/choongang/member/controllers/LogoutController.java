package org.choongang.member.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/logout")
public class LogoutController {

    public String logout(HttpSession session) {
        session.invalidate(); // 세션 비우기 : 로그아웃

        return "redirect:/member/login"; //페이지 이동 response.sendRedirect(...)
    }
}
