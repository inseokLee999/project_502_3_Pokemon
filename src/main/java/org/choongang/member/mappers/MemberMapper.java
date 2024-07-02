package org.choongang.member.mappers;

import org.choongang.member.entities.GetRandPokemon;
import org.choongang.member.entities.Member;

import java.util.List;

public interface MemberMapper {
    long exists(String email);
    Member get(String email);
    int register(Member member);
    int getPokemon(GetRandPokemon params);
    long getMyPokemon(String userName);
    int modify(Member member);
    Member getMemberByUserNo(long userNo);
    List<Member> getAllMember();
}
