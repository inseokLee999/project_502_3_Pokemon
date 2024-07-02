package org.choongang.admin.member;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.admin.advices.AdminControllerAdvice;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.entities.Member;

import java.util.List;

@Controller
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class AdminMemberController {

    private final AdminControllerAdvice adminControllerAdvice;
    private final HttpServletRequest request;
    @GetMapping
    public String index(){

        request.setAttribute("addCss", new String[] {"admin/memberStyle"});

        List<Member> memberList = adminControllerAdvice.getMemberList();
        request.setAttribute("memberList", memberList);
        return "admin/member/index";
    }
}
