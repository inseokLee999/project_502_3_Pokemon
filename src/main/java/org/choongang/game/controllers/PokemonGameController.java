package org.choongang.game.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.game.constants.GameResult;
import org.choongang.global.config.annotations.*;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.exceptions.PokemonNotFoundException;
import org.choongang.game.constants.GameResult;
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

    private void commonProcess() {
        request.setAttribute("addCss", List.of("game/index"));
    }
}