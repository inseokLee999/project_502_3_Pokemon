package org.choongang.game.controllers;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {
    // 게임창
    @GetMapping("/play")
    public String play() {
        return "game/play";
    }
}
