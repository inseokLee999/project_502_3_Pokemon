package org.choongang.main.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final HttpServletRequest request;
    @GetMapping
    public String index(){

        request.setAttribute("addCss", new String[] {"main/index"});
        request.setAttribute("addScript", List.of("main/index"));

        return "main/index";
    }
}
