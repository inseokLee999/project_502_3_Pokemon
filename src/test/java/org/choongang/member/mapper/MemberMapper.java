package org.choongang.member.mapper;

import org.choongang.member.entities.GetRandPokemon;
import org.choongang.member.entities.Member;

public interface MemberMapper {
    int register(Member member);
    long exists(String email);
    Member get(String email);
    int getPokemon(GetRandPokemon params);
    long getMyPokemon(String userName);
}
