package org.choongang.pokemon.tests;

import org.choongang.global.config.DBConn;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.mappers.PokemonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class MemberTest{
    private PokemonMapper mapper;

    @BeforeEach
    public void init(){
        mapper= DBConn.getSession().getMapper(PokemonMapper.class);
    }

    @Test
    void registerTest(){
        LongStream.rangeClosed(1,10).forEach(i->mapper.registerMyPokemon(134,i));
    }
    @Test
    void getMyPokemonsTest(){
        List<PokemonDetail> items = mapper.getMyPokemons(134L);
        items.forEach(System.out::println);
    }
    @Test
    void deleteMyPokemon(){
        int result = mapper.deleteMyPokemon(134L,43L);
    }
    @Test
    void deleteAllMyPokemon(){
        int result = mapper.deleteAllMyPokemon(134L);

    }

    @Test
    void deleteTest(){
        mapper.deleteAllMyPokemon(134);
    }
    @Test
    void getRandomPokemon(){
        for(int i = 0; i<10;i++){
            mapper.registerMyPokemon(134, mapper.getRandom().getSeq());
        }
    }
}