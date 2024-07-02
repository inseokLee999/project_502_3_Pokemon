package org.choongang.game.mappers;

import org.choongang.pokemon.entities.PokemonDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GameMapper {
    PokemonDetail getPokemonByUserNo(long userNo);
    PokemonDetail getPokemonBySeq(long seq);
    List<PokemonDetail> getAllPokemon();
}
