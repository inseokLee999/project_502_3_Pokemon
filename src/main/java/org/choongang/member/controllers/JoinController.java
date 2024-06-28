package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.services.JoinService;

import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class JoinController {
    private final HttpServletRequest request;

    private final JoinService joinService;

    // 회원 가입 양식
    @GetMapping("/join")
    public String join() {
        request.setAttribute("addCss", new String[] {"member/style"});
        return "member/join";
    }

    // 회원 가입 처리
    @PostMapping("/join")
    public String joinPs(JoinRequest form, HttpServletRequest request) {

        joinService.process(form);

        String url = request.getContextPath() + "/member/login";
        String script = String.format("parent.location.replace('%s');", url);

        request.setAttribute("script", script);

        return "commons/execute_script";
    }
}
