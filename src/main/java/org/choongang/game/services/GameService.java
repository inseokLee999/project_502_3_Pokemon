package org.choongang.game.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.choongang.game.mappers.GameMapper;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.GetRandPokemon;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.mappers.PokemonMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.choongang.pokemon.services.PokemonInfoService;

import java.util.List;
import java.util.Random;


@Controller
@Singleton
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameService {

    private MemberMapper memberMapper;
    private GameMapper gameMapper;

    @Inject
    public GameService(MemberMapper memberMapper, PokemonMapper pokemonMapper) {
        this.memberMapper = memberMapper;
        this.gameMapper = gameMapper;
    }

    public GameService(GameMapper gamemapper) {
    }

    public String startGame(long userNo) {
        Member member = memberMapper.getMemberByUserNo(userNo);
        if (member == null || member.getMyPokemonSeq() == 0) {
            throw new IllegalArgumentException("Invalid member or no Pokémon assigned.");
        }

        PokemonDetail userPokemon = gameMapper.getPokemonBySeq(member.getMyPokemonSeq());
        PokemonDetail computerPokemon = getRandomPokemon();

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

    private PokemonDetail getRandomPokemon() {
        List<PokemonDetail> allPokemon = gameMapper.getAllPokemon();
        Random rand = new Random();
        return allPokemon.get(rand.nextInt(allPokemon.size()));
    }
}


