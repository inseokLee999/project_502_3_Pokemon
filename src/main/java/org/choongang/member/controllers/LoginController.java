package org.choongang.member.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class LoginController {
    private final HttpServletRequest request;

    //private final LoginService loginService;

    @GetMapping("/login")
    public String login() {
        request.setAttribute("addCss", new String[] {"member/style"});
        return "member/login";
    }

    @PostMapping("/login")
    public String loginPs(LoginRequest form) {

        //loginService.process(form);

        String redirectUrl = form.getRedirectUrl();
        redirectUrl = redirectUrl == null || redirectUrl.isBlank() ? "/" : redirectUrl;

        String script = String.format("parent.location.replace('%s');", request.getContextPath() + redirectUrl);

        request.setAttribute("script", script);

        return "commons/execute_script";
    }
}
