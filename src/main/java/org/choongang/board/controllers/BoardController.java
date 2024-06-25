package org.choongang.board.controllers;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    //유저게시판쪽
    @GetMapping("/userboard")
    public String userboard() {
        return "board/userboard";
    }
    @PostMapping("/userboard")
    public String userboardPost() {
        return null;
    }
}
