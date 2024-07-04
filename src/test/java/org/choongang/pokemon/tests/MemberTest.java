package org.choongang.pokemon.tests;

import org.choongang.admin.controllers.MemberSearch;
import org.choongang.global.config.DBConn;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.mappers.PokemonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.LongStream;

public class MemberTest{
    private PokemonMapper pokemonMapper;
    private MemberMapper memberMapper;
    @BeforeEach
    public void init(){
        pokemonMapper = DBConn.getSession().getMapper(PokemonMapper.class);
        memberMapper = DBConn.getSession().getMapper(MemberMapper.class);
    }

//    @Test
//    void registerTest(){
//        LongStream.rangeClosed(1,10).forEach(i-> pokemonMapper.registerMyPokemon(177,i));
//    }
//    @Test
//    void getMyPokemonsTest(){
//        List<PokemonDetail> items = pokemonMapper.getMyPokemons(134);
//        items.forEach(System.out::println);
//    }
    @Test
    void deleteMyPokemon(){
        int result = pokemonMapper.deleteMyPokemon(134L,43L);
    }
    @Test
    void deleteAllMyPokemon(){
        int result = pokemonMapper.deleteAllMyPokemon(134L);

    }

    @Test
    void deleteTest(){
        pokemonMapper.deleteAllMyPokemon(134);
    }
    @Test
    void getRandomPokemon(){
        for(int i = 0; i<10;i++){
            pokemonMapper.registerMyPokemon(134, pokemonMapper.getRandom().getSeq());
        }
    }
    @Test
    void getMemberList(){
        MemberSearch memberSearch = new MemberSearch();
        memberSearch.setPage(1);
        memberSearch.setLimit(1);
        List<Member> memberList = memberMapper.getList(memberSearch);
        System.out.println(memberList.stream().toList());
        System.out.println("memberlist.length() = "+ memberList.size());
    }
}