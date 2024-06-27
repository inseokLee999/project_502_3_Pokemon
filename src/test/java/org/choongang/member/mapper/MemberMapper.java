package org.choongang.member.mapper;

import org.choongang.member.entities.Member;

public interface MemberMapper {
    int register(Member member);
    long exist(String email);
    Member get(String email);
}
