/*
package org.choongang.game.services;

import lombok.RequiredArgsConstructor;
import org.choongang.game.mappers.GameMapper;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.global.exceptions.UnAuthorizedException;
import org.choongang.member.entities.Member;
import org.choongang.member.mappers.MemberMapper;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.mappers.PokemonMapper;
import jakarta.inject.Singleton;


@Controller
@Singleton
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameService {

    private MemberMapper memberMapper;
    private GameMapper gameMapper;
    private PokemonMapper pokemonMapper;
*/
/*    @Inject
    public GameService(MemberMapper memberMapper, PokemonMapper pokemonMapper) {
        this.memberMapper = memberMapper;
    }

    public GameService(GameMapper gamemapper) {
    }*//*


    public String startGame(long userNo) {
        Member member = memberMapper.getMemberByUserNo(userNo);
        if (member == null || member.getMyPokemonSeq() == 0) {
            throw new UnAuthorizedException();
        }

        PokemonDetail userPokemon = gameMapper.getPokemonBySeq(member.getMyPokemonSeq());
        PokemonDetail computerPokemon = pokemonMapper.getRandom();

        int userPower = calculatePower(userPokemon);
        int computerPower = calculatePower(computerPokemon);

        System.out.println("User's Pokémon: " + userPokemon);
        System.out.println("Computer's Pokémon: " + computerPokemon);

        if (userPower > computerPower) {
            return "User wins!";
        } else if (userPower < computerPower) {
            return "Computer wins!";
        } else {
            return "It's a tie!";
        }
    }

    private int calculatePower(PokemonDetail pokemon) {
        return pokemon.getWeight() * pokemon.getHeight() * pokemon.getBaseExperience();
    }

*/
/*    private PokemonDetail getRandomPokemon() {
        List<PokemonDetail> allPokemon = gameMapper.getAllPokemon();
        Random rand = new Random();
        return allPokemon.get(rand.nextInt(allPokemon.size()));
    }*//*

}


*/
