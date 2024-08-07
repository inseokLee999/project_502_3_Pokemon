package org.choongang.game.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.game.constants.GameResult;
import org.choongang.game.entities.GameLog;
import org.choongang.game.services.GameLogService;
import org.choongang.global.ListData;
import org.choongang.global.config.annotations.*;
import org.choongang.member.MemberUtil;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.exceptions.PokemonNotFoundException;
import org.choongang.game.services.PokemonGameService;
import org.choongang.pokemon.services.PokemonInfoService;

import java.util.List;

@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class PokemonGameController {

    private final PokemonGameService gameService;
    private final PokemonInfoService infoService;
    private final HttpServletRequest request;
    private final GameLogService logService;
    private final MemberUtil memberUtil;

    @GetMapping
    public String index() {

        return "redirect:/game/step1";
    }

    /**
     * 1단계 : 카드 선택
     * 2단계 : 게임 시작, 결과
     *
     * @return
     */
    @GetMapping("/step1")
    public String step1() {
        commonProcess();

        return "game/step1";
    }

    @PostMapping("/step2")
    public String step2(@RequestParam("seq") long seq) {
        commonProcess();
        PokemonDetail user = infoService.get(seq).orElseThrow(PokemonNotFoundException::new);
        PokemonDetail computer = infoService.getRandom().orElseThrow(PokemonNotFoundException::new);

        GameResult result = gameService.play(user, computer);

        request.setAttribute("user", user);
        request.setAttribute("computer", computer);
        request.setAttribute("result", result);

        return "game/step2";
    }

    @GetMapping("/log")
    public String gameLog(GameLogSearch search) {

        search.setUserNo(memberUtil.getMember().getUserNo());
        ListData<GameLog> data = logService.getList(search);

        request.setAttribute("items", data.getItems());
        request.setAttribute("pagination", data.getPagination());

        return "game/log";
    }


    @GetMapping("/guide")
    public String guide() {

        return "game/guide";
    }

    private void commonProcess() {
        request.setAttribute("addCss", List.of("game/index","game/game"));
        request.setAttribute("addScript", List.of());
    }
}