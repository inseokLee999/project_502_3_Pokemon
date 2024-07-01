package org.choongang.mypage.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {

    private final HttpServletRequest request;

    @GetMapping
    public String index() {
        request.setAttribute("addCss", new String[] {"mypage/mypageStyle"});

        return "mypage/index";
    }



}