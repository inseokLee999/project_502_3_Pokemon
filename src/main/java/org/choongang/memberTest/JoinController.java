package org.choongang.memberTest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.memberTest.JoinService;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    //회원 가입 양식
    @GetMapping("/join")
    public String join() {

        return "member/join";
    }

    //회원 가입 처리
    @PostMapping("/join")
    public String joinPs(org.choongang.memberTest.RequestJoin form, HttpServletRequest request) {

        joinService.process(form);

        String url = request.getContextPath() + "/member/login";
        String script = String.format("parent.location.replace('%s');", url);

        request.setAttribute("script", script);


        return "commons/execute_script";
    }
}
