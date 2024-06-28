package org.choongang.member.mapper;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.config.DBConn;
import org.choongang.pokemon.mappers.PokemonMapper;
import org.junit.jupiter.api.BeforeEach;

public class PokemonMemberTest {
    private SqlSession session;
    private MemberMapper memberMapper;
    private PokemonMapper pokemonMapper;
    @BeforeEach
    void init() {
        session = DBConn.getSession(false);
        pokemonMapper = session.getMapper(PokemonMapper.class);
        memberMapper = session.getMapper(MemberMapper.class);

    }
}
