package org.choongang.admin.member;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.admin.controllers.MemberSearch;
import org.choongang.global.ListData;
import org.choongang.global.Pagination;
import org.choongang.global.config.annotations.*;
import org.choongang.member.entities.Member;

import java.util.List;

@Controller
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class AdminMemberController {

    private final AdminMemberService adminMemberService;
    private final HttpServletRequest request;
    @GetMapping
    public String index(MemberSearch search){

        request.setAttribute("addCss", new String[] {"admin/memberStyle"});

        ListData<Member> memberListData = adminMemberService.getList(search);
        List<Member> memberList = memberListData.getItems();
        Pagination pagination = memberListData.getPagination();
        System.out.println(pagination);
        request.setAttribute("memberList", memberList);
        request.setAttribute("pagination", pagination);
        return "admin/member/index";
    }

    @PostMapping("/process")
    public String process(@RequestParam("mode") String mode, HttpServletRequest request) {

        adminMemberService.process(mode);

        String script = "parent.location.reload();";
        request.setAttribute("script", script);
        return "commons/execute_script";
    }
}
