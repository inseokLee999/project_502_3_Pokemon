package org.choongang.game.services;

import lombok.RequiredArgsConstructor;
import org.choongang.game.mappers.GameLogMapper;
import org.choongang.global.config.annotations.Service;
import org.choongang.member.MemberUtil;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.exceptions.PokemonNotFoundException;
import org.choongang.game.constants.GameResult;
import org.choongang.pokemon.services.PokemonInfoService;
import org.choongang.game.entities.GameLog;


import static org.choongang.game.constants.GameResult.*;

@Service
@RequiredArgsConstructor
public class PokemonGameService {
    private final PokemonInfoService infoService;
    private final GameLogMapper mapper;
    private final MemberUtil memberUtil;

    /**
     *
     * @param seq
     * @return boolean - true : 사용자 승리
     *                   false : 컴퓨터 승리
     */
    public GameResult play(PokemonDetail user, long seq, PokemonDetail computer) {

        // 사용자가 선택한 포켓몬
        if (user != null) {
            user = infoService.get(seq).orElseThrow(PokemonNotFoundException::new);
        }
        int userPoint = user.getHeight() * user.getWeight() * user.getBaseExperience();

        // 컴퓨터가 선택한 포켓몬
        if (computer == null) {
            computer = infoService.getRandom().orElseThrow(PokemonNotFoundException::new);
        }
        int computerPoint = computer.getHeight() * computer.getWeight() * computer.getBaseExperience();

        GameResult result = DRAW; // 무승부
        if (userPoint > computerPoint) {
            result = WIN; // 사용자 승
        } else if (computerPoint > userPoint) {
            result = LOSE; // 컴퓨터 승
        }

        // 기록
        GameLog log = GameLog.builder()
                .userNo(memberUtil.getMember().getUserNo())
                .userSeq(user.getSeq())
                .userScore(userPoint)
                .comSeq(computer.getSeq())
                .comScore(computerPoint)
                .gameResult(result)
                .build();
        mapper.register(log);


        return result;
    }

    public GameResult play(long seq) {
        return play(null, seq, null);
    }

    public GameResult play(PokemonDetail user, PokemonDetail computer) {
        return play(user, user.getSeq(), computer);
    }
}