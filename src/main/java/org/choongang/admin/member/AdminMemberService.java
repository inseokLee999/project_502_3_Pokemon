package org.choongang.admin.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.admin.controllers.MemberSearch;
import org.choongang.global.ListData;
import org.choongang.global.Pagination;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.global.exceptions.AlertException;
import org.choongang.member.constants.UserType;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminMemberService {
    private final MemberMapper mapper;

    /*
    * mode - update : 수정
    *  delete : 삭제
    *
    * @param mode
     */
    void process(String mode) {
        HttpServletRequest request = BeanContainer.getInstance().getBean(HttpServletRequest.class);

        String strMode = mode.equals("delete") ? "삭제" : "수정";

        String[] chks = request.getParameterValues("chk");
        if (chks == null || chks.length == 0) {
            throw new AlertException(strMode + "할 회원을 선택하세요.", HttpServletResponse.SC_BAD_REQUEST);
        }
        for (String chk : chks) {
            String email = request.getParameter("email_" + chk);

            if (mode.equals("delete")) {
                mapper.delete(email);
            } else {
                String userName = request.getParameter("userName_" + chk);
                String userType = request.getParameter("userType_" + chk);

                Member member = Member.builder()
                        .userName(userName)
                        .userType(UserType.valueOf(userType))
                        .email(email)
                        .build();
                mapper.modify(member);
            }
        }
    }

    public ListData<Member> getList(MemberSearch search){
        int page = search.getPage();
        int limit = search.getLimit();
        int offset = (page - 1) * limit + 1; // 레코드 검색 시작 위치
        int endRows = offset + limit; // 레코드 검색 종료 위치
        search.setOffset(offset);
        search.setEndRows(endRows);

        List<Member> members = mapper.getList(search);

        /* 페이징 처리 S */
        int total = mapper.getTotal(search);

        Pagination pagination = new Pagination(page, total, 10, limit, BeanContainer.getInstance().getBean(HttpServletRequest.class));
        /* 페이징 처리 E */
        return new ListData<>(members, pagination);
    }
}
