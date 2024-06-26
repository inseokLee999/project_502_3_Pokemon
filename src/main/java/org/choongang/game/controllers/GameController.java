package org.choongang.game.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {
    // 게임창
    @GetMapping("/play")
    public String play(HttpServletRequest request) {

        request.setAttribute("addCss", List.of("game/play"));

        return "game/play";
    }
}
