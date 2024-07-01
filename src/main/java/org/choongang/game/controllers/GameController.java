package org.choongang.game.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.game.services.GameService;
import org.choongang.global.config.annotations.*;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.global.exceptions.BadRequestException;
import org.choongang.member.entities.Member;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.exceptions.PokemonNotFoundException;
import org.choongang.pokemon.services.PokemonInfoService;

import java.util.List;

@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private PokemonInfoService infoService;
    private HttpServletRequest request;
    private final BeanContainer beanContainer;

    @Inject
    public GameController(PokemonInfoService infoService, HttpServletRequest request) {
        this.infoService = infoService;
        this.request = request;
        this.beanContainer = BeanContainer.getInstance();
        this.beanContainer.loadBeans(); // 모든 빈들을 로딩
    }

    // 게임창
    @GetMapping
    public String play() {
        // BeanContainer에서 필요한 서비스나 객체를 가져와서 사용할 수 있음
        // 예시로 GameService 가져오기
        GameService gameService = beanContainer.getBean(GameService.class);
        // 이후 gameService를 사용하여 게임 관련 로직 처리

        return "game/index";
    }

    @GetMapping("/{userNo}")
    public String view(@PathVariable("userNo") long userNo){
        commonProcess();
        PokemonDetail data;
        data = infoService.get(userNo).<BadRequestException>orElseThrow(() -> new BadRequestException());
        request.setAttribute("data", data);
        return "game/index";
    }

    private void commonProcess() {
        request.setAttribute("addCss", new String[] {"game/index"});
        request.setAttribute("addScript", List.of(" "));
    }
}