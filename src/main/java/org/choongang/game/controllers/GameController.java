/*
package org.choongang.game.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.game.services.GameService;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.global.config.annotations.RequestParam;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.choongang.global.config.containers.BeanContainer;

import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    private final BeanContainer beanContainer;

    public GameController() {
        this.beanContainer = BeanContainer.getInstance();
        this.beanContainer.loadBeans(); // 모든 빈들을 로딩
    }

    // 게임창
    @GetMapping("/play")
    public String play(HttpServletRequest request) {

        request.setAttribute("addCss", List.of("game/play"));

        // BeanContainer에서 필요한 서비스나 객체를 가져와서 사용할 수 있음
        // 예시로 GameService 가져오기
        GameService gameService = beanContainer.getBean(GameService.class);
        // 이후 gameService를 사용하여 게임 관련 로직 처리

        return "game/play";
    }
}*/
