package org.choongang.mycard.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mycard")
public class MyCardController {
    // 게임창
    @GetMapping("/privatecard")
    public String play(HttpServletRequest request) {

        request.setAttribute("addCss", List.of("mycard/privatecard.css"));

        return "mycard/privatecard";
    }
}
