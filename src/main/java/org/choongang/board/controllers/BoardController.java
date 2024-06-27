package org.choongang.board.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final HttpServletRequest request;
    //유저게시판쪽
    @GetMapping("/userboard")
    public String userboard() {
        commonProcess();
        return "board/userboard";

    }

    @PostMapping("/userboard")
    public String userboardPost() {
        return null;
    }
    private void commonProcess() {
        request.setAttribute("addCss", List.of("board/style/d"));
    }
}
