package org.choongang.member.services;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.config.DBConn;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.member.validators.JoinValidator;

// 객체 조립기
public class MemberServiceProvider {
    private static MemberServiceProvider instance;

    private MemberServiceProvider() {}

    public static MemberServiceProvider getInstance() {
        if (instance == null) {
            instance = new MemberServiceProvider();
        }

        return instance;
    }

    public MemberMapper memberMapper() {
        SqlSession session = DBConn.getSession();
        return session.getMapper(MemberMapper.class);
    }

    public JoinValidator joinValidator() {
        return new JoinValidator(memberMapper());
    }

    public JoinService joinService() {
        return new JoinService(joinValidator(), memberMapper());
    }
}
