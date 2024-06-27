package org.choongang.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.member.constants.UserType;
import org.choongang.member.entities.Member;

@Component
@RequiredArgsConstructor
public class MemberUtil {
    public static boolean isLogin(HttpServletRequest request) {

        return getMember(request) != null;
    }

    //관리자 여부.
    public boolean isAdmin(HttpServletRequest request) {
        if (isLogin(request)) {
            Member member = getMember(request);

            return member.getUserType() == UserType.ADMIN;
        }

        return false;
    }

    // 로그인 한 회원정보
    public static Member getMember(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");

        return member;
    }
}
