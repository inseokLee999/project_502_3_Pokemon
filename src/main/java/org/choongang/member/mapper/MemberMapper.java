package org.choongang.member.mapper;

import org.choongang.member.entities.Member;

public interface MemberMapper {
    int exists(String email);
    Member get(String email);
    int register(Member member);

}
