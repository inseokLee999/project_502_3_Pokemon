package org.choongang.mypage.controllers;

import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @GetMapping
    public String index() {

        return "mypage/index";
    }



}