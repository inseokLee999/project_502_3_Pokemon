package org.choongang.member.tests;

import org.choongang.global.config.DBConn;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.junit.jupiter.api.Test;

public class MapperTest {
    @Test
    void test1() {
        MemberMapper mapper = DBConn.getSession().getMapper(MemberMapper.class);
        Member member = mapper.get("test1@test.org");
        System.out.println(member);
    }
}
