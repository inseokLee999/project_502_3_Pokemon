package org.choongang.member.mapper;

import org.choongang.global.config.DBConn;
import org.choongang.global.services.ApiRequestService;
import org.choongang.global.services.ObjectMapperService;
import org.choongang.member.entities.GetRandPokemon;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.mappers.PokemonMapper;
import org.choongang.pokemon.services.PokemonInfoService;
import org.choongang.pokemon.services.PokemonSaveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonMemberTest {
    private PokemonInfoService pokemonInfoService;
    private MemberMapper memberMapper;

    @BeforeEach
    void init() {
        PokemonMapper pokemonMapper = DBConn.getSession().getMapper(PokemonMapper.class);
        PokemonSaveService saveService = new PokemonSaveService(pokemonMapper);
        memberMapper = DBConn.getSession().getMapper(MemberMapper.class);
        pokemonInfoService = new PokemonInfoService(new ApiRequestService(), new ObjectMapperService(), saveService, pokemonMapper);
    }

    @Test
    @DisplayName("랜덤 포켓몬 뽑고 데이터 베이스에 추가")
    void getRandPokemon() {
        PokemonDetail data = pokemonInfoService.getRandom().orElse(null);
        GetRandPokemon getRandPokemon = new GetRandPokemon();
        System.out.printf("seq=%d, name=%s, name_kr=%s\n", Objects.requireNonNull(data).getSeq(), data.getName(), data.getNameKr());
        getRandPokemon.setSeq(data.getSeq());
        getRandPokemon.setUserNo(121);
        int rowsAffected = memberMapper.getPokemon(getRandPokemon);
        assertEquals(1, rowsAffected, "포켓몬 업데이트가 성공적으로 완료되지 않았습니다.");
    }
    @Test@DisplayName("내 포켓몬 정보 불러오기")
    void getMyPokemon(){
        System.out.println(memberMapper.getMyPokemon("inseok"));
    }
}
